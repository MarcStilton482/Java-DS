class Node {
    int data;
    int priority;
    Node next;

    Node(int data, int priority) {
        this.data = data;
        this.priority = priority;
        this.next = null;
    }
}

public class PriorityQueue {
    private Node front;

    public PriorityQueue() {
        front = null;
    }

    public void enqueue(int data, int priority) {
        Node newNode = new Node(data, priority);

        if (front == null || priority < front.priority) {
            newNode.next = front;
            front = newNode;
        } else {
            Node temp = front;
            while (temp.next != null && temp.next.priority <= priority) {
                temp = temp.next;
            }
            newNode.next = temp.next;
            temp.next = newNode;
        }
    }

    public int dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        int data = front.data;
        front = front.next;
        return data;
    }

    public boolean isEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        PriorityQueue pq = new PriorityQueue();

        pq.enqueue(5, 2);
        pq.enqueue(6, 1);
        pq.enqueue(7, 3);
        pq.enqueue(8, 2);
        pq.enqueue(1,5);

        while (!pq.isEmpty()) {
            System.out.println(pq.dequeue());
        }
    }
}
