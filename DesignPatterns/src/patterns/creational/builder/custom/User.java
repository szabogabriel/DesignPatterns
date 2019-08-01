/**
 * 
 */
package patterns.creational.builder.custom;

/**
 * @author javier.alvaro.vasquez.torres@ibm.com
 *
 */
public class User
{
    //All final attributes
    private final String firstName; // required
    private final String lastName; // required
    private final int age; // optional
    private final String phone; // optional
    private final String address; // optional
    private final String address1; // optional
    private final String address2; // optional
 
    public User(UserBuilder builder) {
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
        this.age = builder.age;
        this.phone = builder.phone;
        this.address = builder.address;
        this.address1 = builder.address1;
        this.address2 = builder.address2;
    }
 
    //All getter, and NO setter to provide immutability
    public String getFirstName() {
        return firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public int getAge() {
        return age;
    }
    public String getPhone() {
        return phone;
    }
    public String getAddress() {
        return address;
    }
    public String getAddress1() {
        return address1;
    }
    public String getAddress2() {
        return address2;
    }
 
    @Override
    public String toString() {
        return "User: "+this.firstName+", "+this.lastName+", "+this.age+", "+this.phone+", "+this.address+", "+this.address1+", "+this.address2;
    }
 
    
}


