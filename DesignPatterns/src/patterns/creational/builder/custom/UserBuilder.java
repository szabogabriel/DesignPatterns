/**
 * 
 */
package patterns.creational.builder.custom;

/**
 * @author javier.alvaro.vasquez.torres@ibm.com
 *
 */
public class UserBuilder
{
    final String firstName;
    final String lastName;
    int age;
    String phone;
    String address;
    String address1;
    String address2;

    public UserBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
    public UserBuilder age(int age) {
        this.age = age;
        return this;
    }
    public UserBuilder phone(String phone) {
        this.phone = phone;
        return this;
    }
    public UserBuilder address(String address) {
        this.address = address;
        return this;
    }
    public UserBuilder address1(String address1) {
        this.address1 = address1;
        return this;
    }
    public UserBuilder address2(String address2) {
        this.address2 = address2;
        return this;
    }
    //Return the finally constructed User object
    public User build() {
        User user =  new User(this);
        validateUserObject(user);
        return user;
    }
    private void validateUserObject(User user) {
        //Do some basic validations to check
        //if user object does not break any assumption of system
    }
}