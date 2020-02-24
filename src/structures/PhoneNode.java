package structures;

public class PhoneNode {
    private String data;
    private PhoneNode next;

    public PhoneNode(String data) {
        this.data = data;
        this.next = null;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public PhoneNode getNext() {
        return next;
    }

    public void setNext(PhoneNode next) {
        this.next = next;
    }

}
