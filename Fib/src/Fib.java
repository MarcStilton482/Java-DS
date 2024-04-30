import java.util.Scanner;
public class Fib
{
    static void Fibonnacci(int N)
    {
        int counter = 0;
        int num1 = 0, num2 =1;
        while(counter<=N)
        {
            int num3 = num1 + num2;
            System.out.print(num1+" ");
            num1 = num2;
            num2 = num3;
            counter = counter+1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements to be found in Fibonnacci Series: ");
        int Q = sc.nextInt();
        Fibonnacci(Q);


    }

}