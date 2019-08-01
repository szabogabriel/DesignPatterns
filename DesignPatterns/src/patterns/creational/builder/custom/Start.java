/**
 * 
 */
package patterns.creational.builder.custom;

/**
 * @author javier.alvaro.vasquez.torres@ibm.com
 *
 */
public class Start {
	public static void main(String[] args) {
        User user1 = new UserBuilder("Lokesh", "Gupta")
        .age(30)
        .phone("1234567")
        .address("Fake address 1234")
        .address1("Fake address1 1234 in Bolivia")
        .address2("Really Fake address1 1234 in La Paz Bolivia")
        .build();
     
        System.out.println(user1);
     
        User user2 = new UserBuilder("Jack", "Reacher")
        .age(40)
        .phone("5655")
        //no address
        .build();
     
        System.out.println(user2);
     
        User user3 = new UserBuilder("Super", "Man")
        //No age
        //No phone
        //no address
        .build();
     
        System.out.println(user3);
    }
}
