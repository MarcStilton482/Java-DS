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
    int size = 0 ;

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
        size++;
    }

    public int dequeue() {
        if (QueueIsEmpty()) {
            throw new IllegalStateException("PriorityQueue is empty");
        }
        int data = front.data;
        front = front.next;
        size--;
        return data;

    }
    public int getSize()
    {
        return size;
    }

    public boolean QueueIsEmpty() {
        return front == null;
    }

    public static void main(String[] args) {
        PriorityQueue queue = new PriorityQueue();

        try
        {
            queue.enqueue(5, 2);
            queue.enqueue(6, 1);
            queue.enqueue(7, 3);
            System.out.println("Size of Priority Queue till now:"+ queue.getSize());
            System.out.println();
            queue.enqueue(8, 2);
            queue.enqueue(1, 5);
            queue.dequeue();
            System.out.println("Displaying Priority Queue elements: ");
            while (!queue.QueueIsEmpty()) {
                System.out.println(queue.dequeue());
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
