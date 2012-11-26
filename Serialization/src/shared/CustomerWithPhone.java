package shared;

/**
 * 
 * Since Phone class implements Serializable as well,
 * this class wont have any problems
 *
 */
public class CustomerWithPhone extends Customer {

    private Phone phone;

    
    public Phone getPhone() {
	return phone;
    }

    public void setPhone(Phone phone) {
	this.phone = phone;
    }
}