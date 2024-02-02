import java.lang.Math;
public class LCS
{
    public static String lcp(String s, String t)
    {
        int n = Math.min(s.length(),t.length());
        for(int i = 0;i < n ;i++)
        {
            if(s.charAt(i) != t.charAt(i)){
                return s.substring(0,i);
            }
        }
        return s.substring(0,n);
    }
    public static void main(String[] args)
    {
        String str = "abcdgfhabcdfh";
        String irs = "";
        int n = str.length();
        for (int i = 0; i < n;i++)
        {      for (int j = i + 1; j < n; j++) {
                String x = lcp(str.substring(i, n), str.substring(j, n));
                if (x.length() > irs.length())
                    irs = x;
            }
        }
        System.out.println("Longest Common Substring: "+irs);

    }
}