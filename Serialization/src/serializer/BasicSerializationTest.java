package serializer;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import deserializer.BasicDeserializerTest;

import shared.Customer;
import shared.CustomerWithEmail;
import shared.CustomerWithPhoneAndEmail;
import shared.Email;
import shared.Phone;
import shared.SerializationHelper;
import shared.ancestor.ChildWithSerialization;


/**
 * 
 * This class contains the serialization part of the examples and tests
 * Each test is paired with its matching deserialization test
 * in {@link BasicDeserializerTest}
 *
 */
public class BasicSerializationTest {

    /**
     * serialzie the POJO Customer object
     * run testDeserializingBasicObject to see it working
     * @throws IOException
     */
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
    
    /**
     * show how static fields are not serialized.
     * Run testStatisFieldDeserialization to see the result of deserialization
     * @throws IOException
     */
    @Test
    public void testStaticFieldSerialization() throws IOException {
	// new customer
	Customer.setCssColorNumber(123);
	Customer c = new Customer();
	
	assertEquals(123, c.getCssColorNumber());
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
    }
    
    /**
     * Show how deserializing no serializable objects throw exception
     * @throws IOException
     */
    @Test 
    public void testSerializationChildObjectsEmail() throws IOException {
	// new email customer
	CustomerWithEmail c = new CustomerWithEmail();
	
	c.setEmail(new Email("test@test.test"));
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
	
    }
    
    /**
     * Use of transient keyword to bypass non serializable fields
     * run testTransientDeserialization to deserialze it
     * @throws IOException
     */
    @Test 
    public void testTransientSerialization() throws IOException {
	CustomerWithPhoneAndEmail c = new CustomerWithPhoneAndEmail();
	
	c.setPhone(new Phone(123l));
	c.setEmail(new Email("test@test.test"));
	
	SerializationHelper.serializeObject(c);
	System.out.println("serialized customer");
	
    }
    
    /**
     * A constructor is no called on deserialization of a serializable object,
     * however a parent which does not implement Serializable will have its 
     * constructor called 
     * 
     * run testParentChildDeserialization to see the messages from the constructor
     * @throws IOException
     */
    @Test
    public void testParentChildSerialization() throws IOException {
	ChildWithSerialization child  = new ChildWithSerialization();
	
	SerializationHelper.serializeObject(child);
    }


    /**
     * This example shows how serialization caches objects
     * and changes to objects are not reflected in deserialization, unless
     * the serializer is rested. 
     * 
     * run this example once while reset is commented and once uncommented.
     * 
     * run main method on deserialization side to see it at work.
     * @param args
     * @throws IOException
     * @throws InterruptedException
     */
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
	
	
	/**
	 * uncomment this line to see how resetting will allow us
	 * to read changes / updates
	 * 
	 */
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
