package shared;

/**
 * 
 * Using transient keyword, we can ignore non serializable classes
 * or fields that we dont wish to serialize
 *
 */
public class CustomerWithPhoneAndEmail extends CustomerWithPhone
{
    	
	private transient Email email;
	

	public Email getEmail()
	{
		return email;
	}

	public void setEmail(Email email)
	{
		this.email = email;
	}

}
