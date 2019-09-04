import lombok.Data;
import lombok.NonNull;

/**
 * Class for encapsulation an address.
 */

@Data
public class Address {
    @NonNull private String street;
    @NonNull private String number;
    @NonNull private String postalCode;
    @NonNull private String city;

    @Override
    public String toString() {
        return street + ' ' + number + '\n'
                + postalCode + ' ' +  city;
    }
}
