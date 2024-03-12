class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class CircularLinkedList {

    public static class CLL {
        Node head;
        Node tail;

        public CLL() {
            head = null;
            tail = null;
        }

        public void addNode(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
                newNode.next = head;
            } else {
                tail.next = newNode;
                tail = newNode;
                newNode.next = head;
            }
        }

        public void delNode(int key) {
            if (head == null) {
                System.out.println("List is empty.");
                return;
            }
            Node current = head;
            Node prev = null;
            while (current.data != key) {
                if (current.next == head) {
                    System.out.println("Node with data " + key + " not found.");
                    return;
                }
                prev = current;
                current = current.next;
            }
            if (current == head && current == tail) {
                head = tail = null;
                return;
            }
            if (current == head) {
                prev = head;
                while (prev.next != head)
                    prev = prev.next;
                head = current.next;
                prev.next = head;
            } else if (current == tail) {
                prev.next = head;
                tail = prev;
            } else {
                prev.next = current.next;
            }
        }

        public void display() {
            if (head == null) {
                System.out.println("List is empty.");
            } else {
                Node current = head;
                do {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                } while (current.next != head);
                System.out.print(current.data );
            }
        }

        public static void main(String[] args) {
            CLL cList = new CLL();
            cList.addNode(4);
            cList.addNode(7);
            cList.addNode(2);
            cList.addNode(1);
            cList.addNode(5);
            cList.addNode(7);
            cList.addNode(9);
            cList.addNode(8);
            cList.addNode(2);
            cList.addNode(6);
            cList.display();
            cList.delNode(5);
            System.out.println();
            cList.display();
        }
    }
}
