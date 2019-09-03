import java.util.ArrayList;

public class Person {

    private String firstname;
    private String lastname;
    private ArrayList<Address> addresses;


    public static void setGreeting(String greeting) {
        Person.greeting = greeting;
    }

    public Person(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.addresses = new ArrayList<>();
    }

    private static String greeting = "Hello";

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getGreeting() {
        return greeting + " " + getFirstname() + " " + getLastname() + "!";
    }

    /**
     * Returns the number of elements in this list.
     *
     * @return the number of elements in this list
     */
    public int getAddressCount() {
        return addresses.size();
    }

    /**
     * Returns the element at the specified position in this list.
     *
     * @param  index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Address getAddress(int index) {
        return addresses.get(index);
    }

    /**
     * Appends the specified element to the end of this list.
     *
     * @param address element to be appended to this list
     * @return {@code true} (as specified by {@link Collection#add})
     */
    public boolean addAddress(Address address) {
        return addresses.add(address);
    }

    /**
     * Removes the element at the specified position in this list.
     * Shifts any subsequent elements to the left (subtracts one from their
     * indices).
     *
     * @param index the index of the element to be removed
     * @return the element that was removed from the list
     * @throws IndexOutOfBoundsException {@inheritDoc}
     */
    public Address removeAddress(int index) {
        return addresses.remove(index);
    }

    /**
     * Removes all of the elements from this list.  The list will
     * be empty after this call returns.
     */
    public void clearAddresses() {
        addresses.clear();
    }


    public ArrayList<Address> getAddresss() {
        return addresses; // Referenz kann außerhalb verändert werden
    }

    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }
}
