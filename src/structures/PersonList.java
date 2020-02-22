package structures;

import exceptions.ElementMissingException;

public class PersonList {

    PersonNode head;

    public PersonList() {
        head = null;
    }

    public void insert(Person n) {
        PersonNode pn = new PersonNode(n);

//        if (head == null || head.getData().getFirstName().compareTo(n.getFirstName()) >= 0)
//        {
//            pn.setNext(head);
//            head = pn;
//        }
//        else {
//            PersonNode temp = head;
//
//            while (temp.getNext() != null &&
//                    temp.getNext().getData().getFirstName().compareTo(n.getFirstName()) >= 0)
//                temp = temp.getNext();
//
//            pn.setNext(temp.getNext());
//            temp.setNext(pn);
//        }


        if (head == null)
            head = pn;
        else {
            PersonNode last = head;
            PersonNode temp = head;
            while (temp!=null) {
                System.out.println(temp.getData().getFirstName());
                if (n.getFirstName().compareTo(temp.getData().getFirstName()) <= 0) {
                    break;
                }
                last = temp;
                temp = temp.getNext();
            }
            if (last == head) {
                pn.setNext(head);
                head = pn;
            }else {
                pn.setNext(last.getNext());
                last.setNext(pn);
            }
        }
    }

    public void remove(String firstName) throws ElementMissingException {
        PersonNode last = head;
        PersonNode temp = head.getNext();
        int result = -1;
        while (temp != null) {
            result = firstName.compareTo(temp.getData().getFirstName());
            if (result <= 0){
                break;
            }
            last = temp;
            temp = temp.getNext();
        }

        if (result < 0)
            throw new ElementMissingException();
        else {
            last.setNext(last.getNext().getNext());
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
