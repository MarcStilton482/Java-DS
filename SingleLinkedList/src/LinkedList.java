public class LinkedList
{
    static Node head = null;
    static class Node {
        int data;
        Node next;
        Node(int d) {
            data = d;
            next = null;
        }
        
    }
    public void insert( int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
        }
        else
        {
            Node last = head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = newNode;
        }
    }
    public void printList()
    {
        Node currentNode = head;
        while(currentNode != null)
        {
            if(currentNode == null)
            {
                System.out.print(currentNode.data+"-> Null");
                break;
            }
            System.out.print(currentNode.data+" ->");
            currentNode = currentNode.next;
        }
    }
    public void deleteByValue(int value)
    {
        Node currentNode = head, previous = null;
        if(currentNode != null && currentNode.data == value)
        {
            head = currentNode.next;
            System.out.println(value +" found and deleted.");
            return;
        }
        while (currentNode != null) {
            if (currentNode.data == value) {
                if (previous != null) {
                    previous.next = currentNode.next;
                } else {
                    head = currentNode.next;
                }
                System.out.println(value + " deleted");
                break;
            }
            previous = currentNode;
            currentNode = currentNode.next;
        }

        if(currentNode == null)
        {
            throw new NullPointerException(value +" not found.");
        }
    }
    public void deleteByIndex(int index)
    {
        Node currentNode = head, previous = null;
        if(index < 0)
        {
            throw new IndexOutOfBoundsException("Index " + index + " is out of bounds.");
        }
        if(index==0 && currentNode != null )
        {
            head = currentNode.next;
            System.out.println(index+" index element found and deleted.");
            return;
        }
        int counter = 0;
        while(currentNode !=null)
        {
            if(counter == index)
            {
                previous.next= currentNode.next;
                System.out.println(index+" index element found and deleted.");
                break;

            }
            else {
                previous = currentNode;
                currentNode = currentNode.next;
                counter++;
            }
            if(currentNode == null)
            {
                throw new NullPointerException(index+" not found.");
            }
        }
    }
    public static void main(String[] args)
    {
        try
        {
            LinkedList list = new LinkedList();
            list.insert(4);
            list.insert(5);
            list.insert(3);
            list.insert(1);
            list.insert(7);
            list.insert(9);
            list.insert(3);
            list.insert(2);
            list.insert(8);
            list.insert(4);
            list.printList();
            System.out.println();
            list.deleteByValue(7);
            list.printList();
            System.out.println();
            list.deleteByIndex(5);
            list.printList();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }

    }

}
