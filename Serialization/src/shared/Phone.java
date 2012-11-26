package shared;

import java.io.Serializable;


/**
 * 
 * This class is serializable and is used as a field in customer class
 *
 */
public class Phone implements Serializable
{
	private long phoneNumber;

	public Phone(long number) {
	    this.phoneNumber = number;
	    // TODO Auto-generated constructor stub
	}
	

	public long getPhoneNumber()
	{
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber)
	{
		this.phoneNumber = phoneNumber;
	}
	
	
}
