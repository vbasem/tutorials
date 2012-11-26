package shared;

import java.io.Serializable;


/**
 * 
 * Basic serializable object
 *
 */
public class Customer implements Serializable {
    
    
    /**
     *  a serialversionUID is used to identify a class during ser/des.
     *  Without it, a change in the class will cause deserialization of previous
     *  version to fail.
     */
   // private static final long serialVersionUID = 13490328403221L;
    
    private static int css_color_number;

    private int id;
    private String name;
    private String surname;
    


    public Customer() {
	System.out.println("A new customer is being cosntructed");
    }

    public int getId() {
	return id;
    }

    public void setId(int id) {
	this.id = id;
    }

    public String getName() {
	return name;
    }

    public void setName(String name) {
	this.name = name;
    }

    public String getSurname() {
	return surname;
    }

    public void setSurname(String surname) {
	this.surname = surname;
    }
    

    public static int getCssColorNumber() {
	return css_color_number;
    }

    public static void setCssColorNumber(int colorNumber) {
	Customer.css_color_number = colorNumber;
    }


}
