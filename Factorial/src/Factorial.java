import java.util.Scanner;
public class Factorial {
    public static int Factorial(int number)
    {
        if (number == 1)
            return 1;
        else
            return number *Factorial(number -1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int num;
        System.out.println("Enter a positive number whose factorial need to be find: ");
        num = sc.nextInt();
        System.out.printf("Factorial of number "+ num +" is: "+Factorial(num));
    }
}

//Space Complexity - O(n), Time Complexity - O(n)