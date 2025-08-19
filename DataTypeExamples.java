public class DataTypeExamples {

    public static class Contact {
        String name;
        String address;
        String phone;

        public Contact(String name, String address, String phone) {
            this.name = name;
            this.address = address;
            this.phone = phone;
        }

        @Override
        public String toString() {
            return name + " | " + address + " | " + phone;
        }
    }

    // Ejemplo con primitivos
    public static void primitiveExample(LinkedList<Integer> list) {
        list.insert(10);
        list.insert(20);
        list.insert(30);
    }

    // Ejemplo con cadenas
    public static void stringExample(LinkedList<String> list) {
        list.insert("Hola");
        list.insert("Mundo");
        list.insert("Java");
    }

    // Ejemplo con contactos (complejo/abstracto)
    public static void contactExample(LinkedList<Contact> list) {
        list.insert(new Contact("Juan", "Calle Falsa 123", "555-1234"));
        list.insert(new Contact("Maria", "Av. Central 45", "555-5678"));
        list.insert(new Contact("Pedro", "Calle Sur 89", "555-9012"));
    }
}
