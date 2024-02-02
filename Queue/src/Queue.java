public class Queue{
    public static int front, rear , capacity;
    static int[] queue;
    Queue(int size)
    {
        front = rear = 0;
        capacity = size;
        queue = new int[capacity];
    }
    static  void  enqueue(int item)
    {
        if(capacity == rear)
        {
            System.out.println("Queue is Full");
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
            System.out.println("Queue is empty");
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
        int i;
        if(front == rear)
        {
            System.out.println("Queue is empty");
        }
        for(i = front; i < rear; i++)
        {
            System.out.println(queue[i]);
        }
    }
    static void qfront()
    {
        if(front == rear)
        {
            System.out.println("Queue is empty");
        }
        System.out.println("Front element is: "+queue[front]);
    }
    public static void main(String[] args)
    {
        Queue q  = new Queue(7);
        enqueue(3);
        enqueue(4);
        enqueue(6);
        enqueue(9);
        enqueue(1);
        display();
        dequeue();
        enqueue(8);
        display();
        qfront();

    }
}