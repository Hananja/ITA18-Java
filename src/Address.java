public class Address {
    public String getStreet() {
        return street;
    }

    @Override
    public String toString() {
        return street + ' ' + number + '\n'
                + postalCode + ' ' +  city;
    }

    public Address(String street, String number, String postalCode, String city) {
        this.street = street;
        this.number = number;
        this.postalCode = postalCode;
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    private String street;
    private String number;
    private String postalCode;
    private String city;
}
