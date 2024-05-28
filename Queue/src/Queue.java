public class Queue{
    public static int front, rear , capacity;
    static int[] queue;
    Queue()
    {
        front = rear = 0;
        capacity = 7;
        queue = new int[capacity];
    }
    static  void  enqueue(int item)
    {
        if(capacity == rear)
        {
           throw new QueueOverflowException("Queue Overflow! Can't enqueue any more elements.");
        }
        else
        {
            queue[rear] = item;
            rear++;
        }
    }
    static void dequeue()
    {
        if(front == rear)
        {
            throw new QueueUnderflowException("Queue Underflow! Can't dequeue elements from an empty queue.");
        }
        else
        {
            for(int i = 0; i < rear-1; i++ )
            {
                queue[i] = queue[i+1];
            }
        }
        if(rear < capacity) {
            queue[rear] = 0;
            rear--;
        }
    }
    static void display()
    {
        int element;
        if(front == rear)
        {
            System.out.println("Queue is empty");
        }
        System.out.println("Elements in Queue: ");
        for(element = front; element < rear; element++)
        {
            System.out.println(queue[element]);
        }
        System.out.println();
    }
    static void elementAtFront()
    {
        if(front == rear)
        {
            System.out.println("Queue is empty");
        }
        System.out.println("Front element is: "+queue[front]);
    }
    public static void main(String[] args)
    {
        Queue queue  = new Queue();
        try
        {
            enqueue(3);
            enqueue(4);
            enqueue(6);
            enqueue(9);
            enqueue(1);
            display();
            dequeue();
            enqueue(8);
            display();
            elementAtFront();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}
class QueueOverflowException extends RuntimeException
{
    public  QueueOverflowException(String message)
    {
        super(message);
    }
}
class QueueUnderflowException extends RuntimeException
{
    public  QueueUnderflowException(String message)
    {
        super(message);
    }
}