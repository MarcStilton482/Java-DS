import java.util.Scanner;

public class FibonnacciSeries
{
    static void Fibonnacci(int ElementNumber)
    {
        if(ElementNumber <= 0)
        {
            throw new NegativeNumberException("Negative number encountered! Please enter a positive number.");
        }
        int counter = 0;
        int number1 = 0, number2 =1;
        while(counter<= ElementNumber)
        {
            int number3 = number1 + number2;
            System.out.print(number1 +" ");
            number1 = number2;
            number2 = number3;
            counter = counter+1;
        }
    }
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("Enter number of elements for Fibonnacci Series: ");
            if(!sc.hasNextInt())
                throw new StringException("String character encountered! Please enter a number.");
            int Q = sc.nextInt();
            Fibonnacci(Q);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
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

//Space Complexity - O(1), Time Complexity - O(n)
