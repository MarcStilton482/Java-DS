import java.util.Scanner;
public class Factorial {
    public static int Factorial(int number)
    {
        if (number == 1)
            return 1;
        else if(number == 0)
            return 0;
        else if(number < 0)
            throw new NegativeNumberException("Negative number encountered! Please Enter a non negative number.");

        else
            return number *Factorial(number -1);
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int testNumber;
        System.out.println("Enter a positive number whose factorial need to be find: ");
        try
        {
        if(!sc.hasNextInt())
        {
            throw new StringException("String character encountered! Please enter a number.");
        }
            testNumber = sc.nextInt();
            System.out.printf("Factorial of number "+ testNumber +" is: "+Factorial(testNumber));
        }
        catch (NumberFormatException e)
        {
            System.out.println( e.getMessage());
        }
        catch (Exception e)
        {
            System.out.println( e.getMessage());
        }

    }
}
class NegativeNumberException extends RuntimeException
{
    NegativeNumberException(String message)
    {
        super(message);
    }
}
class StringException extends RuntimeException
{
    StringException(String message)
    {
        super(message);
    }
}


//Space Complexity - O(n), Time Complexity - O(n)