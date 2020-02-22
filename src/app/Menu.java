package app;

import structures.Person;
import structures.PersonList;

import java.util.Scanner;

public class Menu {

    private String[] menuChoices = {"add a new contact", "view all contacts",
                                    "search for a contact", "delete a contact",
                                    "exit program"};

    public void start() {
        System.out.println("Welcome to Snehal's Contact List App");
        int choice = getChoice();

        switch (choice) {
            case 1:
                Scanner sc = new Scanner(System.in);
                Person p = new Person();
                System.out.println("You have chosen to add a new contact");
                System.out.println("Please enter the name of the Person");
                System.out.print("First Name: ");
                p.setFirstName(sc.nextLine());
                System.out.println();
                System.out.println("Last Name: ");
                p.setLastName(sc.nextLine());
                System.out.println();
                break;
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
        sc.close();
        return choice;

    }

    public void test() {
        PersonList l = new PersonList();
        Person p1 = new Person();
        p1.setFirstName("C");
        l.insert(p1);
        Person p2 = new Person();
        p2.setFirstName("B");
        l.insert(p2);
        Person p3 = new Person();
        p3.setFirstName("A");
        l.insert(p3);

        l.print();
    }
}
