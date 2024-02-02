import java.util.Scanner;
public class Factorial {
    public static int Factorial(int k)
    {
        if (k == 1)
            return 1;
        else
            return k*Factorial(k-1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        System.out.println("Enter a positive number whose factorial need to be find: ");
        n = sc.nextInt();
        System.out.printf("Factorial of number "+n+" is: "+Factorial(n));
    }
}