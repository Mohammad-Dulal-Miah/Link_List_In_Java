import java.util.Scanner;

class DoublyLL {
    Scanner sc = new Scanner(System.in);
    static class Node {
        int data;
        Node next;
        Node prev;

        Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    Node head = null;
    Node tail = null;

    public void createLL() {
       
        int data, n = 0;
        do {
            System.out.print("Enter your value: ");
            data = sc.nextInt();
            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
                tail = new_node;
            } else {
                head.prev = new_node;
                new_node.next = head;
                head = new_node;
            }
            System.out.print("Do you like to enter more value: ");
            n = sc.nextInt();
        } while (n == 1);
       
    }

    public void addValue() {
        
        int data, n = 0, pos, index = -1;
        do {
            System.out.print("Enter your value: ");
            data = sc.nextInt();
            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
                tail = new_node;
            } else {
                System.out.print(
                        "Where do you add this value: First Press(1) and add Last press(2) and specific position(3): ");
                pos = sc.nextInt();
                switch (pos) {
                    case 1:
                        head.prev = new_node;
                        new_node.next = head;
                        head = new_node;
                        break;
                    case 2:
                        tail.next = new_node;
                        new_node.prev = tail;
                        tail = new_node;
                        break;
                    case 3:
                        Node temp = head;
                        Node ptr = temp.next;
                        System.out.print("Enter index: ");
                        index = sc.nextInt();

                        for (int i = 1; i < index - 1; i++) {
                            temp = temp.next;
                            ptr = temp.next;
                        }
                        temp.next = new_node;
                        new_node.prev = temp;
                        new_node.next = ptr;
                        ptr.prev = new_node;
                        break;

                    default:
                        System.out.print("Enter valid Input");
                        break;
                }
            }
            System.out.print("Continue add value..Press 1: ");
            n = sc.nextInt();

        } while (n == 1);
       
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteValue() {

      
        int pos, n;
        do {
            if (head == null) {
                System.out.print("Empty list....");
            } else {
                System.out.print("press 1 to delete First and press 2 to delete last and press 3 specific position: ");
                pos = sc.nextInt();

                switch (pos) {
                    case 1:
                        Node temp = head;
                        temp = temp.next;
                        head = temp;
                        head.prev = null;
                        break;

                    case 2:
                        Node temp1 = tail;
                        temp1 = temp1.prev;
                        tail = temp1;
                        tail.next = null;
                        break;
                    case 3:
                        Node temp2 = head;
                        Node ptr = temp2.next;

                        System.out.print("Choose your index: ");
                        int index = sc.nextInt();

                        for (int i = 1; i < index - 1; i++) {
                            temp2 = temp2.next;
                            ptr = temp2.next;
                        }

                        temp2.next = ptr.next;
                        ptr.next.prev = temp2;
                        break;
                    default:
                        System.out.println("Enter valid input");
                        break;
                }
            }
            System.out.print("Continue Press 1:");
            n = sc.nextInt();
        } while (n == 1);
    }

    public void traverse() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.println("NULL");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        DoublyLL dl = new DoublyLL();
        // dl.createLL();
        dl.addValue();
        dl.traverse();
        dl.deleteValue();
        dl.traverse();
    }
}