import java.util.Scanner;

class SingularLL {
    static class Node {
        Node next;
        int data;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node head = null;

    public void creation() {
        int data, n;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Enter  integer number: ");
            data = sc.nextInt();
            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
            } else {
                new_node.next = head;
                head = new_node;
            }
            System.out.print("Do u like to enter more value. Press(1): ");
            n = sc.nextInt();
        } while (n == 1);
        sc.close();
    }

    public void addNumber() {

        Scanner sc = new Scanner(System.in);
        int data, n = 1, pos, index;
        do {
            System.out.print("Enter  integer number: ");
            data = sc.nextInt();
            Node new_node = new Node(data);

            if (head == null) {
                head = new_node;
            } else {
                System.out.print("Where do you want to add value? first(1) and last(2) and specific position(3): ");
                pos = sc.nextInt();

                switch (pos) {

                    case 1:
                        new_node.next = head;
                        head = new_node;
                        break;
                    case 2:
                        Node temp = head;
                        while (temp.next != null) {
                            temp = temp.next;
                        }

                        temp.next = new_node;
                        break;
                    case 3:
                        Node temp1 = head;
                        Node ptr = temp1.next;
                        System.out.print("Enter index: ");
                        index = sc.nextInt();
                        for (int i = 1; i < index - 1; i++) {
                            temp1 = temp1.next;
                            ptr = temp1.next;
                        }
                        temp1.next = new_node;
                        new_node.next = ptr;
                        break;
                    default:
                        System.out.print("Invalid");

                }
                System.out.print("Do you want add more value: Press 1: ");
                n = sc.nextInt();
            }
            
        } while (n == 1);
    }

    public void traverse() {
        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + "-->");
            temp = temp.next;
        }
        System.out.print("NULL");
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        SingularLL sl = new SingularLL();
        sl.addNumber();
        sl.traverse();
    }
}
