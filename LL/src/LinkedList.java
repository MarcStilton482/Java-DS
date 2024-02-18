public class LinkedList
{
    Node head;
    static class Node {
        int data;
        Node next;


        Node(int d) {
            data = d;
            next = null;
        }
    }
    public static void insert(LinkedList list, int data)
    {
        Node new_node = new Node(data);
        if(list.head == null)
        {
            list.head = new_node;
        }
        else
        {
            Node last = list.head;
            while(last.next != null)
            {
                last = last.next;
            }
            last.next = new_node;
        }
    }
    public static void printList(LinkedList list)
    {
        Node currNode = list.head;
        while(currNode != null)
        {
            if(currNode.next == null)
            {
                System.out.print(currNode.data);
                break;
            }
            System.out.print(currNode.data+" ->");
            currNode= currNode.next;
        }
    }
    public static void del_key(LinkedList list , int key)
    {
        Node currNode = list.head, prev = null;
        if(currNode != null && currNode.data == key)
        {
            list.head = currNode.next;
            System.out.println(key+" found and deleted.");
            return;
        }
        while (currNode != null) {
            if (currNode.data == key) {
                if (prev != null) {
                    prev.next = currNode.next;
                } else {
                    list.head = currNode.next;
                }
                System.out.println(key + " deleted");
                break;
            }
            prev = currNode;
            currNode = currNode.next;
        }

        if(currNode == null)
        {
            System.out.println(key+" not found.");
        }
    }
    public static void del_pos(LinkedList list, int index)
    {
        Node currNode = list.head, prev = null;
        if(index==0 && currNode != null )
        {
            list.head = currNode.next;
            System.out.println(index+" found and deleted.");
            return;
        }
        int counter = 0;
        while(currNode!=null)
        {
            if(counter == index)
            {
                prev.next= currNode.next;
                System.out.println(index+" found and deleted.");
                break;

            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
            if(currNode == null)
            {
                System.out.println(index+" not found.");
            }
        }
    }
    public static void main(String[] args)
    {
        LinkedList list = new LinkedList();
        insert(list,4);
        insert(list,5);
        insert(list,3);
        insert(list,1);
        insert(list,7);
        insert(list,9);
        insert(list,3);
        insert(list,2);
        insert(list,8);
        insert(list,0);
        printList(list);
        System.out.println();
        del_key(list,7);
        printList(list);
        System.out.println();
        del_pos(list,5);
        printList(list);


    }

}