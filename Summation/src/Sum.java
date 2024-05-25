import java.util.Scanner;
public class Sum
{

    public static int SigmaOp(int num)
    {

        if(num == 0)
            return 0;
        else if(num == 1)
            return 1;
        else
            return num+SigmaOp(num-1);

    }
    public static void main(String[] args)
    {
        System.out.println("Enter a non negative number: ");
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        System.out.printf("Factorial of number "+ number +" is: "+SigmaOp(number));
    }

}
//Space Complexity - O(n), Time Complexity - O(n)