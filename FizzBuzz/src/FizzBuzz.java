import java.util.Scanner;
public class FizzBuzz
{
    FizzBuzz(int element)
    {
        if(element <= 0)
            throw new NegativeNumberException("Negative number encountered! Please Enter element non negative number.");
        for(int i = 1; i <= element; i++)
        {
            if(i % 3 == 0 && i % 5 == 0 )
            {
                System.out.println("FizzBuzz");
            }
            else if (i % 3 == 0)
            {
                System.out.println("Fizz");
            }
            else if (i % 5 == 0)
            {
                System.out.println("Buzz");
            }
            else
            {
                System.out.println(i);
            }

        }
    }
    public static void main(String[] args)
    {
        try
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter item number: ");
            if(!sc.hasNextInt()) throw new StringException("String character encountered! Please enter item number.");
            int item = sc.nextInt();
            new FizzBuzz(item);
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