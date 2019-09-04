import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import java.util.ArrayList;
import java.util.Collection;

@RequiredArgsConstructor
public class Person {
    @NonNull @Setter private static String greeting = "Hello";

    @NonNull @Getter @Setter private String firstname;
    @NonNull @Getter @Setter private String lastname;
    @Getter private ArrayList<Address> addresses = new ArrayList<>();;

    /**
     * Get greeting.
     * @return Build and return greeting with full name
     */
    public String getGreeting() {
        return greeting + " " + getFullName() + "!";
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

    /**
     * Build full Name with first and lastname.
     * @return full name of person
     */
    public String getFullName() {
        return getFirstname() + " " + getLastname();
    }
}
