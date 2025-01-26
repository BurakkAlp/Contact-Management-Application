import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManager manager = new ContactManager();

        while (true) {
            System.out.println("1. Add Contact");
            System.out.println("2. Search Contact");
            System.out.println("3. Update Contact");
            System.out.println("4. Delete Contact");
            System.out.println("5. Display All Contacts");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Company Name: ");
                    String companyName = scanner.nextLine();
                    System.out.print("Enter Job Title: ");
                    String jobTitle = scanner.nextLine();

                    BusinessContact contact = new BusinessContact(name, phoneNumber, email, companyName, jobTitle);
                    manager.addContact(contact);
                    break;

                case 2:
                    System.out.print("Enter Name to Search: ");
                    String searchName = scanner.nextLine();
                    manager.searchContact(searchName);
                    break;

                case 3:
                    System.out.print("Enter Name to Update: ");
                    String updateName = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhone = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    manager.updateContact(updateName, newPhone, newEmail);
                    break;

                case 4:
                    System.out.print("Enter Name to Delete: ");
                    String deleteName = scanner.nextLine();
                    manager.deleteContact(deleteName);
                    break;

                case 5:
                    manager.displayAllContacts();
                    break;

                case 6:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
