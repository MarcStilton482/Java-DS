class Node
{
    int data;
    Node next;
    Node previous;
    public Node (int data)
    {
        this.data = data;
        this.next = null;
        this.previous = null;
    }


}
public class DoubleLinkedList {
    public static Node head = null;
    public static Node tail = null;
    public void traverseForward()
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
    public void traverseReverse()
    {
        Node current = tail;
        System.out.println("Reverse Traversal: ");
        while(current != null)
        {
            System.out.println(current.data+" ");
            current = current.previous;
        }
        System.out.print("Null");
        System.out.println();

    }
    public void insertAtBeginning(int data)
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
            head.previous = temp;
            head = temp;
        }
    }
    public void insertAtEnd(int data)
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
            temp.previous = tail;
            tail = temp;
        }
    }
    public void insertAtPosition(int data, int pos)
    {
        Node temp = new Node(data);
        if (pos == 1 )
        {
            insertAtBeginning(data);
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
                insertAtEnd(data);
            }
            else
            {
                temp.next = current;
                temp.previous = current.previous;
                current.previous.next = temp;
                current.previous = temp;
            }
        }
    }
    public void deleteAtBeginning()
    {
        if(head == null)
        {
            throw new NullPointerException("No element is present to carry out deletion operation at beginning");

        }
        if (head == tail)
        {
            head = null;
            tail = null;
            return;
        }
        Node temp = head;
        head = head.next;
        head.previous = null;
        temp.next = null;
    }
    public void deleteAtEnd()
    {
        if(tail == null)
        {
            throw new NullPointerException("No element is present to carry out deletion operation at end");
        }
        if (head == tail)
        {
            head = null;
            tail = null;
            return;
        }
        Node temp = tail;
        tail = tail.previous;
        tail.next = null;
        temp.previous = null;
    }
    public void deleteAtPosition(int pos)
    {
        if(head == null)
        {
            return;
        }
        if(pos == 1)
        {
            deleteAtBeginning();
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
            throw new NullPointerException("Wrong Position entered.");

        }
        if(current == tail){
            deleteAtEnd();
            return;
        }
        current.previous.next = current.next;
        current.next.previous = current.previous;
        current.previous = null;
        current.next = null;
    }
    public  void displayDoubleLinkedList(Node head)
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
        try
        {
            DoubleLinkedList list = new DoubleLinkedList();
            list.insertAtEnd(2);
            list.insertAtEnd(5);
            list.insertAtEnd(1);
            list.insertAtEnd(4);
            list.traverseReverse();
            list.insertAtEnd(9);
            list.displayDoubleLinkedList(head);
            list.insertAtBeginning(9);
            list.insertAtPosition(12, 3);
            list.displayDoubleLinkedList(head);
            list.displayDoubleLinkedList(head);
            list.deleteAtEnd();
            list.traverseForward();
            list.deleteAtBeginning();
            list.displayDoubleLinkedList(head);
            list.deleteAtPosition(5);
            list.displayDoubleLinkedList(head);
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }

    }
}