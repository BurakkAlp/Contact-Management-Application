import java.io.*;
import java.util.*;

public class ContactManager {
    private List<Contact> contactList;
    private static final String FILE_NAME = "contacts.csv";

    // Constructor
    public ContactManager() {
        contactList = new ArrayList<>();
        loadContactsFromCSV();
    }

    // Add a contact
    public void addContact(Contact contact) {
        contactList.add(contact);
        saveContactsToCSV();
    }

    // Search contact by partial or exact name
    public void searchContact(String name) {
        List<Contact> results = new ArrayList<>();
        for (Contact contact : contactList) {
            if (contact.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(contact);
            }
        }
        if (results.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            for (Contact result : results) {
                result.displayContact();
                System.out.println("--------------------------");
            }
        }
    }

    // Update contact details
    public void updateContact(String name, String newPhoneNumber, String newEmail) {
        Contact contact = contactList.stream()
            .filter(c -> c.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
        if (contact != null) {
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            saveContactsToCSV();
            System.out.println("Contact updated.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Delete contact
    public void deleteContact(String name) {
        Contact contact = contactList.stream()
            .filter(c -> c.getName().equalsIgnoreCase(name))
            .findFirst()
            .orElse(null);
        if (contact != null) {
            contactList.remove(contact);
            saveContactsToCSV();
            System.out.println("Contact deleted.");
        } else {
            System.out.println("Contact not found.");
        }
    }

    // Display all contacts in alphabetical order
    public void displayAllContacts() {
        contactList.sort(Comparator.comparing(Contact::getName));
        for (Contact contact : contactList) {
            contact.displayContact();
            System.out.println("--------------------------");
        }
    }

    // Save contacts to CSV file
    private void saveContactsToCSV() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_NAME))) {
            for (Contact contact : contactList) {
                BusinessContact business = (BusinessContact) contact;
                writer.println(contact.getName() + "," + contact.getPhoneNumber() + "," + contact.getEmail() + "," +
                        business.getCompanyName() + "," + business.getJobTitle());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Load contacts from CSV file
    private void loadContactsFromCSV() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {  // Name, phone number, email, company name, job title
                    BusinessContact contact = new BusinessContact(parts[0], parts[1], parts[2], parts[3], parts[4]);
                    contactList.add(contact);
                }
            }
        } catch (FileNotFoundException e) {
            // File not found, starting with an empty contact list
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
