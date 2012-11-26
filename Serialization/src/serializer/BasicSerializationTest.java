package serializer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

import org.junit.Test;
import org.junit.experimental.categories.Categories.ExcludeCategory;
import org.junit.experimental.theories.Theory;

import shared.Customer;
import shared.CustomerWithEmail;
import shared.CustomerWithPhoneAndEmail;
import shared.Email;
import shared.Phone;
import shared.SerializationHelper;
import shared.ancestor.ChildWithSerialization;

import static org.junit.Assert.*;

public class BasicSerializationTest {

    @Test
    public void testSerializationSimpleObject() throws IOException {

	// new customer
	Customer c = new Customer();

	c.setId(123);
	c.setName("James");
	c.setSurname("Blony");

	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
    }
    
    @Test
    public void testStaticFieldSerialization() throws IOException {
	// new customer
	Customer.setCssColorNumber(123);
	Customer c = new Customer();
	
	assertEquals(123, c.getCssColorNumber());
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
    }
    
    @Test 
    public void testSerializationChildObjectsEmail() throws IOException {
	// new email customer
	CustomerWithEmail c = new CustomerWithEmail();
	
	c.setEmail(new Email("test@test.test"));
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
	
    }
    
    @Test 
    public void testTransientSerialization() throws IOException {
	CustomerWithPhoneAndEmail c = new CustomerWithPhoneAndEmail();
	
	c.setPhone(new Phone(123l));
	c.setEmail(new Email("test@test.test"));
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
	
    }
    
    @Test
    public void testParentChildSerialization() throws IOException {
	ChildWithSerialization child  = new ChildWithSerialization();
	
	SerializationHelper.serializeObject(child);
    }

    public static void main(String[] args) throws IOException,
	    InterruptedException {
	testMutatingSerialiyation();
    }
    
    

    private static void testMutatingSerialiyation() throws IOException {
	Customer c = new Customer();

	c.setId(123);
	c.setName("James");
	c.setSurname("Blony");

	serialize(c);
	
	waitForKeyPress();

	// change customer
	c.setId(456);
	c.setName("Fake");
	c.setSurname("Blony");
	
	
	// reset
	// resetSerializer();
	
	serialize(c);
    }
    
    private static void resetSerializer() throws IOException {
	SerializationHelper.globalOos.reset();
    }
    
    private static void serialize(Object o) throws IOException {
	SerializationHelper.contuniesSerialization(o);
	
	System.out.println("serialized customer\n");
    }

    private static void waitForKeyPress() {
	Scanner scanner = new Scanner(System.in);
	System.out
		.println("--------------\nPress Enter to update customer data and serialize again\n--------------------");

	scanner.nextLine();
    }

}
