public class CircularQueue {
    int front, rear, size;
    int capacity;
    int[] array;

    CircularQueue() {
        front = rear = -1;
        capacity = 5;
        array = new int[capacity];
        size = 0;
    }

    void enqueue(int item) {
        if (queueIsFull()) {
            throw new QueueOverflowException("Queue Overflow! Can't enqueue elements in a full Queue.");
        } else if (queueIsEmpty()) {
            front = rear = 0;
        } else {
            rear = (rear + 1) % capacity;
        }
        array[rear] = item;
        size++;
    }

    void dequeue() {
        if (queueIsEmpty()) {
            throw new QueueUnderflowException("Queue Underflow! Can't dequeue elements from an empty Queue.");
        }

        if (front == rear) {
            front = rear = -1;
        } else {
            front = (front + 1) % capacity;
        }
        size--;
    }

    boolean queueIsFull() {
        return size == capacity;
    }

    boolean queueIsEmpty() {
        return size == 0;
    }
    void queueGetSize()
    {
        System.out.println(" Size of Queue : "+size);
    }

    void display() {
        if (queueIsEmpty()) {
            throw new QueueUnderflowException("Queue Underflow! Can't display elements from an empty Queue.");
        }
        System.out.println("Elements in Queue: ");
        for (int i = 0; i < size; i++) {
            int index = (front + i) % capacity;
            System.out.print(array[index] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        CircularQueue queue = new CircularQueue();
        try {
            queue.enqueue(3);
            queue.enqueue(4);
            queue.enqueue(0);
            queue.enqueue(9);
            queue.enqueue(1);
            queue.display();
            queue.dequeue();
            queue.enqueue(8);
            queue.display();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}

class QueueOverflowException extends RuntimeException {
    public QueueOverflowException(String message) {
        super(message);
    }
}

class QueueUnderflowException extends RuntimeException {
    public QueueUnderflowException(String message) {
        super(message);
    }
}
