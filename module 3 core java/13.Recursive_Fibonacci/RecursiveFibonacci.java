import java.util.Scanner;

public class RecursiveFibonacci {
    // Recursive method to calculate Fibonacci number
    static int fibonacci(int n) {
        if (n <= 1)
            return n;
        else
            return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a positive integer: ");
        int n = input.nextInt();

        if (n < 0) {
            System.out.println("Please enter a non-negative integer.");
            return;
        }

        int result = fibonacci(n);
        System.out.println("Fibonacci number at position " + n + " is: " + result);
    }
}
