import java.util.LinkedList;
import java.util.Queue;

class Node
{
    int data;
    Node left, right;
    Node(int data)
    {
        this.data = data;
        left = right = null;
    }

}
public class BinaryTree
{
    static Node root;
    public static void insert(int data) {
        if (root == null)
        {
            root = new Node(data);
            return;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty())
        {
            Node temp = queue.poll();
            if(temp.left == null)
            {
                temp.left = new Node(data);
                break;
            }
            else
                queue.offer(temp.left);
            if(temp.right == null)
            {
                temp.right = new Node(data);
                break;
            }
            else
                queue.offer(temp.right);
        }
    }
    public static void deleteDeepest(Node deleteNode)
    {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node temp;
        while(!queue.isEmpty())
        {
            temp = queue.poll();
            if(temp == deleteNode)
            {
                temp = null;
                deleteNode = null;
                return;
            }
            if(temp.right != null)
            {
                if(temp.right == deleteNode)
                {
                    temp.right = null;
                    deleteNode = null;
                    return;
                }
                else
                    queue.offer(temp.right);
            }
            if(temp.left != null)
            {
                if(temp.left == deleteNode)
                {
                    temp.left = null;
                    deleteNode = null;
                    return;
                }
                else
                    queue.offer(temp.left);
            }
        }

    }
    public static void deleteKey(int key)
    {
        if(root == null)
            return;
        if(root.left == null && root.right == null)
        {
            if (root.data == key)
                root = null;
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node temp = null;
        Node keyNode = null;
        while(!queue.isEmpty())
        {
            temp = queue.poll();
            if(temp.data == key)
                keyNode = temp;
            if(temp.left != null)
                queue.offer(temp.left);
            if(temp.right != null)
                queue.offer(temp.right);
        }
        if(keyNode != null)
        {
            int x = temp.data;
            keyNode.data = x;
            deleteDeepest(temp);
        }

    }
    public static void inOrderTraversal()
    {
        inOrderTraverse(root);
        System.out.print("null");
    }
    public static void inOrderTraverse(Node node)
    {
        if(node == null)
            return;
        inOrderTraverse(node.left);
        System.out.print(node.data+" -> ");
        inOrderTraverse(node.right);
    }
    public static void preOrderTraversal()
    {
        preOrderTraverse(root);
        System.out.print("null");
    }
    public static void preOrderTraverse(Node node)
    {
        if(node == null)
            return;
        System.out.print(node.data+" -> ");
        preOrderTraverse(node.left);
        preOrderTraverse(node.right);
    }
    public static void postOrderTraversal()
    {
        postOrderTraverse(root);
        System.out.print("null");
    }
    public static void postOrderTraverse(Node node)
    {
        if(node == null)
            return;
        postOrderTraverse(node.left);
        postOrderTraverse(node.right);
        System.out.print(node.data+" -> ");
    }
    public static void main(String[] args)
    {
        insert(10);
        insert(20);
        insert(30);
        insert(40);

        System.out.print("PreOrder traversal: ");
        preOrderTraversal();

        System.out.print("\nInOrder traversal: ");
        inOrderTraversal();

        System.out.print("\nPostOrder traversal: ");
        postOrderTraversal();

        System.out.print("\nLevel Order traversal: ");

        // Delete the node with data = 20
        deleteKey(20);

        System.out.print("\nInOrder traversal after deletion: ");
        inOrderTraversal();    }
}