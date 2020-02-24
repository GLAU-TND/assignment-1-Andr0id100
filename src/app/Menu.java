package app;

import exceptions.ElementMissingException;
import structures.Person;
import structures.PersonList;

import java.util.Scanner;

public class Menu {

    private String[] menuChoices = {"add a new contact", "view all contacts",
                                    "search for a contact", "delete a contact",
                                    "exit program"};
    private PersonList personList = new PersonList();
    public void start()throws ElementMissingException {
        System.out.println("Welcome to Snehal's Contact List App");
        while (true) {
            options(getChoice());
        }


    }

    private int getChoice() {
        Scanner sc = new Scanner(System.in);

        for (int i = 1; i <= menuChoices.length; i++) {
            System.out.println("Press " + i + " to " + menuChoices[i - 1]);
        }
        System.out.println();
        int choice;
        do {
            choice = sc.nextInt();
            if (choice < 1 || choice > menuChoices.length){
                System.out.println("Invalid choice.\nPlease try again:");
            }
        } while (choice < 1 || choice > menuChoices.length);
        return choice;

    }

    public void options(int choice) throws ElementMissingException{
        Scanner sc = new Scanner(System.in);
        switch (choice) {

            case 1:
                Person p = new Person();
                System.out.println("You have chosen to add a new contact");
                System.out.println("Please enter the name of the Person");
                System.out.print("First Name: ");
                p.setFirstName(sc.nextLine());
                System.out.print("Last Name: ");
                p.setLastName(sc.nextLine());
                System.out.print("Contact Number: ");
                p.addPhone(sc.nextLine());
                System.out.print("Would you like to add another contact number? (y/n): ");
                while (sc.nextLine().compareTo("y")==0){
                    System.out.print("Contact Number: ");
                    p.addPhone(sc.nextLine());
                    System.out.print("Would you like to add another contact number? (y/n): ");
                }
                System.out.println("Would ypu like to add email address? (y/n): ");
                if (sc.nextLine().compareTo("y")==0) {
                    System.out.print("Email address: ");
                    p.setEmail(sc.nextLine());
                }
                personList.insert(p);
                break;
            case 2:
                System.out.println("---Here are all your contacts---");
                personList.print();
                break;
            case 3:
                System.out.println("You could search for a contact from their first names:");
                String firstName = sc.nextLine();
                personList.search(firstName);
                break;
            case 4:
                System.out.println("Here are all your contacts");
                personList.printFirstNames();
                System.out.print("Press the number against the contact to delete it:" );
                int n = sc.nextInt();
                sc.nextLine();
                personList.removeIndex(n);
                System.out.println("Contact deleted from list");
                personList.printFirstNames();
                break;
        }
    }
}
