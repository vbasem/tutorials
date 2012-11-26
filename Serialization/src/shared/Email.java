package shared;

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
