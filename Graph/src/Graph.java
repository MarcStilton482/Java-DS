import java.util.Scanner;
public class Graph
{
    int Vertex;
    int[][] adjMatrix;
    public Graph(int v)
    {
        Vertex = v;
        adjMatrix = new int[Vertex][Vertex];
    }
    public  void addEdge(int src, int dest)
    {
        adjMatrix[src][dest] = 1;
        adjMatrix[dest][src] = 1;
    }
    public  void delEdge(int src, int dest)
    {
        if(src < 0 || src > Vertex || dest < 0 || dest > Vertex )
        {
            System.out.println("Invalid vertex edge "+src+" , "+dest);
        }
        else if(adjMatrix[src][dest] != 1)
        {
            System.out.println("The edge doesn't exist "+src+" , "+dest);

        }
        else
            {
                adjMatrix[src][dest] = 0;
                adjMatrix[dest][src] = 0;
            }
    }
    public void prtGraph()
    {
        for(int i = 0; i < Vertex; i++)
        {
            for(int j = 0;j < Vertex; j++)
            {
                System.out.print(adjMatrix[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of vertices in graph: ");
        int vert = sc.nextInt();
        Graph graph = new Graph(vert);
        while(true)
        {
            System.out.println("Menu \n1. Adding Edge \n2. Deleting Edge \n3. Printing Adjacency Matrix \n4.Exit");
            int choice = sc.nextInt();
            switch(choice)
            {
                case 1:
                    System.out.print("Enter edge to add (source and destination): ");
                    int srcAdd = sc.nextInt();
                    int destAdd = sc.nextInt();
                    graph.addEdge(srcAdd, destAdd);
                    break;
                case 2:
                    System.out.print("Enter edge to remove (source and destination): ");
                    int srcRemove = sc.nextInt();
                    int destRemove = sc.nextInt();
                    graph.delEdge(srcRemove, destRemove);
                    break;
                case 3:
                    System.out.println("Adjacency Matrix of the graph:");
                    graph.prtGraph();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}