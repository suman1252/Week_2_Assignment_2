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
            String string = input.nextLine();
            if (isInteger(string)) {
                System.out.println(Constant.VALID_STRING);
                continue;
            }

            if (string.equalsIgnoreCase("exit")) {
                break; 
            }

            int result = countPalindromeSubstrings(string);
            System.out.println("Input: " + string + " -> Output: " + result + "\n");
        }
    }

    // Method to count all palindrome substrings in the string
    public static int countPalindromeSubstrings(String input) {
        return countPalindromesRecursive(input, 0);
    }

    // Recursive function to traverse the string and count palindromes at each index
    private static int countPalindromesRecursive(String input, int index) {
        if (index == input.length()) {
            return 0;
        }
        int count = countPalindromesFromCenter(input, index, index) 
                  + countPalindromesFromCenter(input, index, index + 1);
        return count + countPalindromesRecursive(input, index + 1);
    }

    // Recursive function to count palindromes expanding from a center (for odd and even lengths)
    private static int countPalindromesFromCenter(String input, int left, int right) {
        if (left < 0 || right >= input.length() || input.charAt(left) != input.charAt(right)) {
            return 0;
        }
        return 1 + countPalindromesFromCenter(input, left, right + 1);
    }

    // Method to check if a string is an integer
    private static boolean isInteger(String input) {
        try {
            Integer.parseInt(input);
            return true; 
        } catch (NumberFormatException e) {
            return false;
        }
    }
}