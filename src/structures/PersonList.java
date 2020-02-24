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
            System.out.print(temp.getData().getFirstName()+" -> ");
            temp = temp.getNext();
        }
        System.out.println("null");
    }

}
