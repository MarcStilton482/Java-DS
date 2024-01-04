import java.util.Scanner;
public class Str_Rev
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a String: ");
        String Str1 = sc.nextLine();
        String Rev1 = "";
        char c;
        for(int i = Str1.length()-1;i>=0;i--)
        {
            c = Str1.charAt(i);
            Rev1 = Rev1+c;
        }
        System.out.println("Original String: "+Str1);
        System.out.println("Reversed String: "+Rev1);
    }
}