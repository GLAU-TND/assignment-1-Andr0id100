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
            PhoneNode temp = head.getNext();
            temp.setNext(n);
        }
        count++;
    }



}
