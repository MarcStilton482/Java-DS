public class Queue
{
    public int capacity;
    public int[] arr;
    public int head ;
    public int tail ;
    Queue(int size)
    {
        head = tail = 0;
        capacity = size;
        arr = new int[capacity];
    }
    void Enqueue(int x)
    {
        if(capacity==tail)
        {
            System.out.println(("Queue is Full"));
        }
        else
        {
            arr[tail] = x;
            tail++;
        }

    }
    void Dequeue()
    {
        if(head==tail)
        {
            System.out.println("Queue is empty");
        }
        else
        {
            for(int i = 0; i < tail-1 ;i++)
            {
                arr[i] = arr [i+1];
            }
        }
        if(tail<capacity)
        {
            arr[tail] = 0;
            tail--;
        }
    }
    void display()
    {
        if(head==tail)
        {
            System.out.println("Queue is empty");

        }
        else
        {

            for(int i = head; i<tail;i++)
            {
                System.out.println(arr[i]);
            }
        }
    }
    public static void main(String[] args)
    {
        Queue q = new Queue(7);
        System.out.println("Before any operation performed.");
        q.display();
        q.Enqueue(3);
        q.Enqueue(2);
        q.Enqueue(4);
        q.Enqueue(6);
        q.Enqueue(1);
        System.out.println("After En-queuing: ");
        q.display();
        q.Dequeue();
        q.Dequeue();
        System.out.println("After De-queuing: ");
        q.display();
    }
}