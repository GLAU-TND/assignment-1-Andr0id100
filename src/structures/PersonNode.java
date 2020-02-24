package structures;

public class PersonNode {
    private Person data;
    private PersonNode next;

    public PersonNode(Person p) {
        data = p;
        next = null;
    }


    public Person getData() {
        return data;
    }

    public PersonNode getNext() {
        return next;
    }

    public void setNext(PersonNode next) {
        this.next = next;
    }

    public void printCard() {
        System.out.println("-------- * -------- * -------- * --------");
        System.out.println("First Name: " + this.getData().getFirstName());
        System.out.println("Last Name: " + this.getData().getLastName());
        this.getData().printNumbers();
        if (this.getData().getEmail()=="")
            System.out.println("Email address: "+this.getData().getEmail());
        System.out.println("-------- * -------- * -------- * --------");
    }
}
