import java.util.HashMap;

public class HashTableContactBook {

    HashMap<String, Contact> contacts = new HashMap<>();

    void add(Contact c) {
        contacts.put(c.name, c);
    }

    Contact search(String name) {
        return contacts.get(name);
    }

    void delete(String name) {
        contacts.remove(name);
    }

    void display() {
        for (Contact c : contacts.values()) {
            System.out.println(c);
        }
    }
}