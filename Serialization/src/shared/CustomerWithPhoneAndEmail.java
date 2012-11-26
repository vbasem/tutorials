package shared;

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
