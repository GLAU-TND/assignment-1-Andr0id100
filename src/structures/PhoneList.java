package structures;

public class PhoneList {

    private PhoneNode head;
    private int count;

    public PhoneList() {
        head = null;
        count = 0;
    }

    public void insert(String s) {
        PhoneNode n = new PhoneNode(s);
        if (head == null){
            head = n;
        }
        else {
            n.setNext(head);
            head = n;
        }
        count++;
    }


    public void printNumbers() {
        if (count == 1){
            System.out.print("Contact Number: ");
        }
        else {
            System.out.print("Contact Number(s): ");
        }

        PhoneNode temp = head;
        while (temp != null) {
            System.out.print(temp.getData());
            temp = temp.getNext();
            if (temp != null)
                System.out.print(", ");
        }
        System.out.println();
    }

}
