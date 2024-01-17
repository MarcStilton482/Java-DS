class Node
{
    int data;
    Node next;
    Node prev;
    public Node (int data)
    {
        this.data = data;
        this.next = null;
        this.prev = null;
    }


}
public class Dll {
    public static Node head = null;
    public static Node tail = null;
    public void travFor()
    {
        Node current = head;
        System.out.println("Forward Traversal: ");
        while(current != null)
        {
            System.out.println(current.data+" ");
            current = current.next;
        }
        System.out.print("Null");
        System.out.println();

    }
    public void travRev()
    {
        Node current = tail;
        System.out.println("Reverse Traversal: ");
        while(current != null)
        {
            System.out.println(current.data+" ");
            current = current.prev;
        }
        System.out.print("Null");
        System.out.println();

    }
    public void insertBeg(int data)
    {
        Node temp = new Node(data);
        if(head == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
    }
    public void insertEnd(int data)
    {
        Node temp = new Node(data);
        if(tail == null)
        {
            head = temp;
            tail = temp;
        }
        else
        {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
    }
    public void insertatPos(int data, int pos)
    {
        Node temp = new Node(data);
        if (pos == 1 )
        {
            insertBeg(data);
        }
        else
        {
            Node current = head;
            int currPosition = 1;
            while(current != null && currPosition<pos )
            {
                current = current.next;
                currPosition++;
            }
            if(current== null)
            {
                insertEnd(data);
            }
            else
            {
                temp.next = current;
                temp.prev = current.prev;
                current.prev.next = temp;
                current.prev = temp;
            }
        }
    }
    public void delAtBeg()
    {
        if(head == null)
        {
            return;
        }
        if (head == tail)
        {
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
    }
    public void delAtEnd()
    {
        if(tail == null)
        {
            return;
        }
        if (head == tail)
        {
            head = null;
            tail = null;
            return;
        }
        Node temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
    }
    public void del(int pos)
    {
        if(head == null)
        {
            return;
        }
        if(pos == 1)
        {
            delAtBeg();
            return;
        }
        Node current = head;
        int count = 1;
        while(current != null && count != pos)
        {
            current =current.next;
            count++;
        }
        if(current == null)
        {
            System.out.println("Wrong Position");
            return;
        }
        if(current == tail){
            delAtEnd();
            return;
        }
        current.prev.next = current.next;
        current.next.prev = current.prev;
        current.prev = null;
        current.next = null;
    }
    public  void display(Node head)
    {
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + " --> ");
            temp = temp.next;
        }
        System.out.print("Null");
        System.out.println();


    }
    public static void main(String[] args)
    {
        Dll list = new Dll();
        list.insertEnd(2);
        list.insertEnd(5);
        list.insertEnd(1);
        list.insertEnd(4);
        list.travRev();
        list.insertEnd(9);
        list.display(head);
        list.insertBeg(9);
        list.insertatPos(12,3);
        list.display(head);
        list.del(2);
        list.display(head);
        list.delAtEnd();
        list.travFor();
        list.delAtBeg();
        list.display(head);
        list.del(5);
        list.display(head);





    }
}