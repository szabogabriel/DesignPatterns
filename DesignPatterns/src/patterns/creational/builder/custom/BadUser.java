/**
 * 
 */
package patterns.creational.builder.custom;

/**
 * @author javier.alvaro.vasquez.torres@ibm.com
 *
 */
public class BadUser {
	
    String firstName; // required
    String lastName; // required
    String middleName; // required
    String singleFullName; // optional
    int age; // optional
    String phone; // optional
    String address; // optional
    String addressLine1; // optional
    String state; // optional
    String country; // optional
    int phoneNumber; // required
	/**
	 * @param firstName
	 * @param lastName
	 * @param middleName
	 * @param singleFullName
	 * @param age
	 * @param phone
	 * @param address
	 * @param addressLine1
	 * @param state
	 * @param country
	 * @param phoneNumber
	 */
	public BadUser(String firstName, String lastName, String middleName, String singleFullName, int age, String phone,
			String address, String addressLine1, String state, String country, int phoneNumber) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.middleName = middleName;
		this.singleFullName = singleFullName;
		this.age = age;
		this.phone = phone;
		this.address = address;
		this.addressLine1 = addressLine1;
		this.state = state;
		this.country = country;
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the singleFullName
	 */
	public String getSingleFullName() {
		return singleFullName;
	}
	/**
	 * @param singleFullName the singleFullName to set
	 */
	public void setSingleFullName(String singleFullName) {
		this.singleFullName = singleFullName;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the addressLine1
	 */
	public String getAddressLine1() {
		return addressLine1;
	}
	/**
	 * @param addressLine1 the addressLine1 to set
	 */
	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the phoneNumber
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    
    
    
    

}
