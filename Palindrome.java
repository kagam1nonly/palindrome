import java.util.Scanner;
import java.math.BigInteger;

public class Palindrome
{
    /*
        Palindrome Program

        This Palindrome program is a Java application that determines whether a given number, when added to its reverse, forms a palindrome. A palindrome is a number or text that reads the same forwards and backwards.

        The program prompts the user to enter the total number of test cases, followed by each positive integer to be tested. It performs up to 10 additions, checking if the sum is a palindrome. If a palindrome is found within the limit, it displays the palindrome. Otherwise, it prints "NONE" along with the last sum.

        Features:
        - Supports multiple test cases
        - Handles large numbers using BigInteger class
        - Implements constraints to ensure valid input
        - Provides clear and concise output

        Usage:
        1. Enter the total number of test cases.
        2. For each test case, input a positive integer.
        3. The program will perform the required additions and display the result.

        Constraints:
        - The input number must be at least 2 digits positive.
        - The input number must not exceed 16 characters.
        - The program terminates if a palindrome is found within 10 additions.

        Feel free to explore and use this program to check for palindromes in different numbers!

        Sample input:
                1
                999999999999999
        Sample output:
               NONE, 7198399999999928016
        Another sample input:
                1
                87
        Another sample output:
                4884 is a palindrome
     */
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        int T;
        int count = 0;
        T = scan.nextInt();

        while (count < T)
        {
            boolean isPalindrome = false;
            int numAdditions = 0;

            // First number (N)
            BigInteger N = scan.nextBigInteger();

            // Check if N is not at least 2 digits positive or exceeds 16 characters
            if (N.compareTo(BigInteger.TEN) < 0 || N.toString().length() >= 16)
            {
                System.out.println("Integer N must be at least 2 digits positive and not exceed 16 characters.");
                return;
            }

            while (numAdditions <= 10 && !isPalindrome)
            {
                String XStr = String.valueOf(N);
                StringBuilder sb1 = new StringBuilder();
                sb1.append(XStr);
                sb1.reverse();
                BigInteger Y = new BigInteger(sb1.toString());
                BigInteger Total = N.add(Y);

                // Check if the total is a palindrome
                String totalStr = String.valueOf(Total);
                String reversedTotalStr = new StringBuilder(totalStr).reverse().toString();
                if (totalStr.equals(reversedTotalStr))
                {
                    System.out.println(Total + " is a palindrome");
                    isPalindrome = true;
                }
                else
                {
                    N = Total;
                    if (numAdditions == 10)
                    {
                        System.out.println("NONE, " + Total);
                        break;
                    }
                }
                numAdditions++;
            }
            count++;
        }
    }
}
