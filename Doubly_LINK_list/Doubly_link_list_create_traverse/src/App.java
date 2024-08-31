import java.util.Scanner;

class DoublyLL {

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
        Scanner sc = new Scanner(System.in);
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
        sc.close();
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
        DoublyLL dl = new DoublyLL();
        dl.createLL();
        dl.traverse();
    }
}
