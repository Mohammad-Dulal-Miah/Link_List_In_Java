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
        sl.creation();
        sl.traverse();
    }
}
