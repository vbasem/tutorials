package deserializer;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.Scanner;

import org.junit.Test;

import shared.Customer;
import shared.CustomerWithPhoneAndEmail;
import shared.Phone;
import shared.SerializationHelper;
import shared.ancestor.ChildWithSerialization;

public class BasicDeserializerTest {

    @Test
    public void testDeserializingBasicObject() throws ClassNotFoundException,
	    IOException {
	Customer c = (Customer) SerializationHelper.deserializerObject();

	assertEquals(c.getId(), 123);
	assertEquals(c.getName(), "James");
	assertEquals(c.getSurname(), "Blony");

    }
    
    @Test
    public void testStatisFieldDeserialization() throws ClassNotFoundException, IOException {
	Customer c = (Customer) SerializationHelper.deserializerObject();
	
	assertFalse(c.getCssColorNumber() == 123);
    }
    
    @Test
    public void testTransientDeserialization() throws ClassNotFoundException, IOException {
	CustomerWithPhoneAndEmail c = (CustomerWithPhoneAndEmail) SerializationHelper.deserializerObject();
	
	assertEquals(123l, c.getPhone().getPhoneNumber());
	assertNull(c.getEmail());
    }
    
    @Test 
    public void testParentChildDeserialization() throws ClassNotFoundException, IOException {
	ChildWithSerialization child  = (ChildWithSerialization) SerializationHelper.deserializerObject();
	
	
    }

    public static void main(String[] args) throws ClassNotFoundException,
	    IOException, InterruptedException {
	testContinuesDeserialization();
    }

    public static void testContinuesDeserialization()
	    throws ClassNotFoundException, IOException, InterruptedException {

	deserilize();

	waitForKeyPRess();

	deserilize();

    }

    private static void deserilize() throws ClassNotFoundException, IOException {
	Customer c = (Customer) SerializationHelper.continuesDeserialization();

	printCustomer(c);
    }

    private static void waitForKeyPRess() {
	System.out
		.println("---------------\nPress Enter to read next object\n-------------------");
	Scanner sc = new Scanner(System.in);

	sc.nextLine();
    }

    private static void printCustomer(Customer c) {
	System.out.println("Customer id = " + c.getId());
	System.out.println("Customer name = " + c.getName());
	System.out.println("Customer surname = " + c.getSurname());
    }

}
