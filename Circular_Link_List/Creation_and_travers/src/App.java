import java.util.Scanner;

class CircularLL {

    Scanner scanner = new Scanner(System.in);

    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void creationLL() {
        int data, con;
        do {
            System.out.print("Enter number value: ");
            data = scanner.nextInt();

            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
                tail = new_node;
                tail.next = head;
            } else {
                new_node.next = head;
                head = new_node;
                tail.next = head;
            }

            System.out.print("Continue and Press(1): ");
            con = scanner.nextInt();

        } while (con == 1);
    }

    public void insertionLL(){

        int data , n , con , index;
        do{
            System.out.print("Enter data: ");
            data = scanner.nextInt();
            Node new_node = new Node(data);

            if(head == null){
                head = new_node;
                tail = new_node;
                tail.next = head;
            }
            else{
                System.out.print("insert first Press(1) and insert last Press(2) and specific position Press(3): ");
                con = scanner.nextInt();

                switch (con) {
                    case 1:

                        new_node.next = head;
                        head = new_node;
                        tail.next = head;
                        break;
                    case 2:
                       
                        tail.next = new_node;
                        tail = new_node;
                        tail.next = head;
                        break;
                    case 3:
                        Node temp = head;
                        Node ptr = temp.next;

                        System.out.print("Choose your index: ");
                        index = scanner.nextInt();

                        for(int i = 1; i<index-1;i++){
                            temp = temp.next;
                            ptr = temp.next;
                        }

                        temp.next = new_node;
                        new_node.next = ptr;
                        break;
                    default:
                        System.out.print("Invalid input");
                        break;
                }
            }
            System.out.print("Continue add number. Press(1)");
            n = scanner.nextInt();
        }while(n==1);
    }
    public void deletionLL(){

        int n , con , index;
        do{
           

            if(head == null){
                System.out.print("Empty Link List....");
            }
            else{
                System.out.print("delete first Press(1) and delete last Press(2) and specific position Press(3): ");
                con = scanner.nextInt();

                switch (con) {
                    case 1:
                        Node temp = head;
                        temp = temp.next;
                        head = temp;
                        tail.next = head;
                        break;
                    case 2:
                       
                        Node temp1 = head;
                        Node ptr = temp1.next;

                        while(ptr.next != head){
                            temp1= ptr;
                            ptr = ptr.next;
                        }
                        tail = temp1;
                        tail.next = head;
                        break;
                    case 3:
                        Node temp2 = head;
                        Node ptr2 = temp2.next;

                        System.out.print("Choose your index: ");
                        index = scanner.nextInt();

                        for(int i = 1; i<index-1;i++){
                            temp2 = temp2.next;
                            ptr2 = temp2.next;
                        }

                        temp2.next = ptr2.next;
                        break;
                    default:
                        System.out.print("Invalid input");
                        break;
                }
            }
            System.out.print("Continue delete number. Press(1)");
            n = scanner.nextInt();
        }while(n==1);
    }

    public void traverse() {
        Node temp = head;

        do {
            System.out.print(temp.data + "-");
            temp = temp.next;
        } while (temp != head);
        System.out.print("Null");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        CircularLL cl = new CircularLL();
        cl.insertionLL();
        cl.traverse();
        cl.deletionLL();
        cl.traverse();
    }
}
