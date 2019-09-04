public class Main {

    public static void main(String[] args) {
        Person.setGreeting("Hallo");

        Person p1 = new Person( "Otto", "Walkes" );
        System.out.println(p1.getGreeting());

        p1.addAddress( new Address(
                        "Hinter dem Nordwind",
                        "1019",
                        "25567",
                        "Ostfriesland"
        ));

        Person p2 = new Person( "Angela", "Merkel");
        System.out.println(p2.getGreeting());

        System.out.println(); // --------------------

        Address a1 = new Address(
                "Am Reichstag",
                "139 b",
                "10123",
                "Berlin"
        );

        Address a2 = new Address(
                "Zwischen den Stühlen",
                "42",
                "10456",
                "Potsdam"
        );

        p2.addAddress(a1);
        p2.addAddress(a2);

        for( Address address: p2.getAddresses()) {
            System.out.println(p2.getFullName());
            System.out.println(address);
            System.out.println();
        }
    }
}
