/***
 * Suman Kumari 
 * 12-09-2024
 * Purpose of this program is to count the number of palindrome 
 * substrings in a given string entered by the user.
 */
package Week_2_Assignment_2;
import java.util.Scanner;

public class CountPalindrome {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(Constant.STRING);
            String originalString = input.nextLine();
            if (isInteger(originalString)) {
                System.out.println(Constant.VALID_STRING);
                continue;
            }
            if (originalString.equalsIgnoreCase("exit")) {
                break; 
            }
            int result = countPalindromeSubstrings(originalString);
            System.out.println("Output: " + result + "\n");
        }
    }

    // Method to count all palindrome substrings in the string
    public static int countPalindromeSubstrings(String inputString) {
        return countPalindromesRecursive(inputString, 0);
    }

    // Recursive function to traverse the string and count palindromes at each index
    private static int countPalindromesRecursive(String inputString, int indexCount) {
        if (indexCount == inputString.length()) {
            return 0;
        }
        int count = countPalindromesFromCenter(inputString, indexCount, indexCount) 
                  + countPalindromesFromCenter(inputString, indexCount, indexCount + 1);
        return count + countPalindromesRecursive(inputString, indexCount + 1);
    }

    // Recursive function to count palindromes expanding from a center (for odd and even lengths)
    private static int countPalindromesFromCenter(String inputString, int left, int right) {
        if (left < 0 || right >= inputString.length() || inputString.charAt(left) != inputString.charAt(right)) {
            return 0;
        }
        return 1 + countPalindromesFromCenter(inputString, left, right + 1);
    }

    // Method to check if a string is an integer
    private static boolean isInteger(String inputString) {
        try {
            Integer.parseInt(inputString);
            return true; 
        }
        catch (NumberFormatException e) {
            return false;
        }
    }
}