class Node {
    int data;
    Node next;

    Node(int d) {
        data = d;
        next = null;
    }
}

public class CircularLinkedList {

    public static class CircularLinkedListTest {
        Node head;
        Node tail;

        public CircularLinkedListTest() {
            head = null;
            tail = null;
        }

        public void addNode(int data) {
            Node newNode = new Node(data);
            if(head == null)
            {
                head = newNode;
            }
            else
            {
                tail.next = newNode;
            }
                tail = newNode;
                newNode.next = head;

        }

        public void deleteNode(int key) {
            if (head == null) {
                throw new NullPointerException("Linked List is Empty.");
            }
            Node current = head;
            Node previous = null;
            while (current.data != key) {
                if (current.next == head) {
                    System.out.println("Node with data " + key + " not found.");
                    return;
                }
                previous = current;
                current = current.next;
            }
            if (current == head && current == tail) {
                head = tail = null;
                return;
            }
            if (current == head) {
                previous = head;
                while (previous.next != head)
                    previous = previous.next;
                head = current.next;
                previous.next = head;
            } else if (current == tail) {
                previous.next = head;
                tail = previous;
            } else {
                previous.next = current.next;
            }
        }

        public void display() {
            if (head == null) {
                throw new NullPointerException("Linked List is Empty.");
            }
            else
            {
                Node current = head;
                do {
                    System.out.print(current.data + " -> ");
                    current = current.next;
                } while (current.next != head);
                System.out.print(current.data );
            }
        }

        public static void main(String[] args) {
            CircularLinkedListTest circularLinkedList = new CircularLinkedListTest();
            try
            {
                circularLinkedList.addNode(4);
                circularLinkedList.addNode(7);
                circularLinkedList.addNode(2);
                circularLinkedList.addNode(1);
                circularLinkedList.addNode(5);
                circularLinkedList.addNode(7);
                circularLinkedList.addNode(9);
                circularLinkedList.addNode(8);
                circularLinkedList.addNode(2);
                circularLinkedList.addNode(6);
                circularLinkedList.display();
                circularLinkedList.deleteNode(5);
                System.out.println();
                circularLinkedList.display();
            }
            catch(Exception e)
            {
                System.out.println(e.getMessage());
            }
        }
    }
}
