

class SingleLinkedList
{
    Node head;
    static class Node
    {
        int data;
        Node next;
        Node(int d)
        {
            data =d;
            next = null;
        }

    }
    public static void insert(SingleLinkedList list, int data)
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
    public static void printList(SingleLinkedList list)
    {
        Node currNode = list.head;
        System.out.print("Linked List: ");
        while (currNode != null)
        {
            if(currNode.next == null)
            {
                System.out.print(currNode.data);
                break;
            }
            System.out.print(currNode.data+" -> ");
            currNode = currNode.next;
        }
    }
    public static void delete_key(SingleLinkedList list, int key)
    {
        Node currNode = list.head, prev = null;
        if (currNode != null && currNode.data == key)
        {
            list.head = currNode.next;
            System.out.println(key+" Found and Deleted");
            return;
        }
        while(currNode != null && currNode.data != key)
        {
            prev = currNode;
            currNode = currNode.next;
        }
        if(currNode != null)
        {
            prev.next = currNode.next;
            System.out.println(key+" Found and Deleted.");
        }
        if(currNode == null)
        {
            System.out.println("Key not found.");

        }
    }
    public static SingleLinkedList delete_pos(SingleLinkedList list, int index)
{
    Node currNode= list.head,prev = null;
    if (index == 0 && currNode != null)
    {
        list.head = currNode.next;
        System.out.println(index+ " position element deleted.");
    }
    else
    {
        int counter = 0;
        while (currNode!= null)
        {
            if (counter == index)
            {
                prev.next = currNode.next;
                System.out.println(index+ " position element deleted.");
                break;

            }
            else {
                prev = currNode;
                currNode = currNode.next;
                counter++;
            }
        }
        if (currNode == null)
        {
            System.out.println(index+" Not found");
        }

    }
    return list;
}
    public static void main(String[] args)
    {
        SingleLinkedList list = new SingleLinkedList();
        insert(list, 1);
        insert(list, 5);
        insert(list, 7);
        insert(list, 2);
        insert(list, 4);
        delete_key(list, 7);

        printList(list);
        System.out.println();
        list = delete_pos(list,2);
        printList(list);

    }
}
