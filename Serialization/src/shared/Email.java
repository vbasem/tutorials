package shared;

/**
 * 
 * This class is not Serializable
 *
 */
public class Email {
    private String email;

    public Email(String address) {
	this.email = address;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }
}
