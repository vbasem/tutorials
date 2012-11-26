package shared;

/**
 * 
 * Serializing this class will fail, since Email is not
 * serializable and is not marked as transient
 *
 */
public class CustomerWithEmail extends Customer {
    
	private Email email;
	

	public Email getEmail()
	{
		return email;
	}

	public void setEmail(Email email)
	{
		this.email = email;
	}

}
