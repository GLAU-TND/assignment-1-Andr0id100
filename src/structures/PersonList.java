package structures;

import exceptions.ElementMissingException;

public class PersonList {

    PersonNode head;

    public PersonList() {
        head = null;
    }

    public void insert(Person n) {
        PersonNode pn = new PersonNode(n);

        if (head == null || n.getFirstName().compareTo(head.getData().getFirstName()) <= 0)
        {
            pn.setNext(head);
            head = pn;
        }
        else {
            PersonNode temp = head;

            while (temp.getNext() != null &&
                    n.getFirstName().compareTo(temp.getNext().getData().getFirstName()) >= 0)
                temp = temp.getNext();

            pn.setNext(temp.getNext());
            temp.setNext(pn);
        }

    }

    public void remove(String firstName) throws ElementMissingException {
        if (head == null){
            throw new ElementMissingException();
        }
        else if (head.getData().getFirstName().compareTo(firstName) == 0) {
            head = head.getNext();
        }
        else {
            PersonNode temp = head;
            while (temp.getNext() != null &&
                    firstName.compareTo(temp.getNext().getData().getFirstName()) > 0)
                temp = temp.getNext();

            if (temp.getNext()!=null) {
                temp.setNext(temp.getNext().getNext());
            }
            else {

                throw new ElementMissingException();
            }
        }
    }

    public void print() {

        PersonNode temp = head;
        while (temp!=null){
            temp.printCard();
            temp = temp.getNext();
        }
    }

    public void search(String firstName) {
        PersonNode temp = head;
        boolean flag = false;
        while (temp!=null && temp.getData().getFirstName().compareTo(firstName) <= 0) {
            if (temp.getData().getFirstName().compareTo(firstName) == 0){
                flag = true;
                temp.printCard();
            }
            temp = temp.getNext();
        }
        if (!flag) {
            System.out.println("NO RESULTS FOUND");
        }
    }

    public void printFirstNames() {
        int index = 1;
        PersonNode temp = head;
        while (temp!=null) {
            System.out.println(index+". "
                    +temp.getData().getFirstName()
                    +" "+temp.getData().getLastName());
            temp = temp.getNext();
        }
    }

    public void removeIndex(int n) throws ElementMissingException{
        PersonNode temp = head;
        for (int i=1;i<n;i++)
            temp = temp.getNext();
        remove(temp.getData().getFirstName());
    }
}
