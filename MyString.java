/***
 * Suman Kumari
 * 11-09-2024
 * Program is designed to offer a simple interface for performing various 
 * string-related and number conversion tasks.
 */
package Week_2_Assignment_2;
import java.util.Scanner;

public class MyString {
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println(Constant.SELECT_OPTION);
            System.out.println(Constant.ENTER_0);
            System.out.println(Constant.ENTER_1);
            System.out.println(Constant.ENTER_2);
            System.out.println(Constant.ENTER_3);
            System.out.println(Constant.ENTER_4);
            System.out.print(Constant.ENTER_CHOICE);
            int choice = input.nextInt();
            input.nextLine();
            switch (choice) {
                case 0:
                    System.out.println("Exiting...");
                    return;
                case 1:
                    Fibonacci();
                    break;
                case 2:
                    CountConsonants();
                    break;
                case 3:
                    CamelCaseConversion();
                    break;
                case 4:
                    BinaryToDecimal();
                    break;
                default:
                    System.out.println(Constant.INVALID_CHOICE);
            }
        }
    }
    /***
     * Java program to print the nth number in the Fibonacci series without using loops.
     */
    public static void Fibonacci() {
        System.out.print(Constant.ENTER_THE_POSITION);
        try {
            int number = input.nextInt();
            if (number < 0) {
                System.out.println(Constant.NON_NEGATIVE_INTEGER);
                return;
            }
            long result = NthFibonacci(number);
            System.out.println(Constant.OUTPUT + result);
        }
        catch (Exception e) {
            System.out.println(Constant.ENTER_VALID_INPUT);
            input.next();
        }
    }
    // Recursive method to find the nth Fibonacci number
    public static long NthFibonacci(int number) {
        if (number == 0) {
            return 0;
        }
        else if (number == 1) {
            return 1;
        }
        return NthFibonacci(number - 1) + NthFibonacci(number - 2);
    }
    /***
     * Java program that takes a string as input and finds the number of consonants in the string.
     */
    public static void CountConsonants() {
        System.out.println(Constant.ENTER_STRING);
        String originalString = input.nextLine();
        if (!originalString.matches("[a-zA-Z]+")) {
            System.out.println(Constant.ENTER_VALID_STRING);
            return; 
        }
        int consonantCount = countConsonants(originalString, 0);
        System.out.println(Constant.OUTPUT + consonantCount);
    }
    // Method to count consonants in a string
    public static int countConsonants(String string, int index) {
        if (index >= string.length()) {
            return 0;
        }
        char character = Character.toLowerCase(string.charAt(index));
        if ((character >= 'a' && character <= 'z') && !(character == 'a' || character == 'e' || character == 'i' || character == 'o' || character == 'u')) {
            return 1 + countConsonants(string, index + 1);
        }
        else {
            return countConsonants(string, index + 1);
        }
    }
    /***
     * Java program where the user inputs a string in snake_case and
     *  convert it to snake_case, and then to camelCase.
     */
    public static void CamelCaseConversion() {
        System.out.println(Constant.ENTER_STRING);
        try {
            String originalString = input.nextLine();
            if (originalString.matches(".*\\d.*")) {
                System.out.println(Constant.ENTER_INVALID_INPUT);
                return;
            }
            String snakeCaseString = toSnakeCase(originalString, 0);
            String camelCaseString = toCamelCase(snakeCaseString, 0, false);
            System.out.println(Constant.OUTPUT + camelCaseString);
        }
        catch (Exception e) {
            System.out.println(Constant.INVALID_CHOICE);
        }
    }
    // Recursive method to convert a string to snake_case
    public static String toSnakeCase(String string, int index) {
        if (index >= string.length()) {
            return "";
        }
        char character = string.charAt(index);
        if (character == ' ') {
            return "_" + toSnakeCase(string, index + 1);
        }
        else if (Character.isUpperCase(character)) {
            return "_" + Character.toLowerCase(character) + toSnakeCase(string, index + 1);
        }
        else {
            return character + toSnakeCase(string, index + 1);
        }
    }
    // Recursive method to convert a snake_case string to camelCase
    public static String toCamelCase(String string, int index, boolean capitalizeNext) {
        if (index >= string.length()) {
            return "";
        }
        char character = string.charAt(index);
        if (character == '_') {
            return toCamelCase(string, index + 1, true);
        }
        else {
            if (capitalizeNext) {
                return Character.toUpperCase(character) + toCamelCase(string, index + 1, false);
            }
            else {
                return character + toCamelCase(string, index + 1, false);
            }
        }
    }
    /***
     * Java program to convert binary representation to decimal representation.
     */
    public static void BinaryToDecimal() {
    	System.out.print(Constant.BINARY_NUMBER);
        String binaryString = input.nextLine();
        if (isValidBinary(binaryString)) {
            int decimalValue = binaryToDecimal(binaryString, binaryString.length() - 1);
            System.out.println(Constant.OUTPUT + decimalValue);
        }
        else {
            System.out.println(Constant.VALID_BINARY_NUMBER);
        }
    }
    // Method to validate if the string is a valid binary number
    public static boolean isValidBinary(String binaryString) {
        return binaryString.matches("[01]+");
    }
    // Recursive method to convert a binary string to a decimal value
    public static int binaryToDecimal(String binaryString, int index) {
        if (index < 0) {
            return 0;
        }
        char digit = binaryString.charAt(index);
        int digitValue = (digit == '1') ? 1 : 0;
        int powerOfTwo = 1 << (binaryString.length() - 1 - index);
        return binaryToDecimal(binaryString, index - 1) + (digitValue * powerOfTwo);
    }
}