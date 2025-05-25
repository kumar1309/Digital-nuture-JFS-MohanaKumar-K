import java.util.Scanner;

public class SimpleCalculator {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter first number: ");
        double num1 = input.nextDouble();

        System.out.print("Enter second number: ");
        double num2 = input.nextDouble();

        System.out.println("Choose operation: +, -, *, /");
        char op = input.next().charAt(0);

        double result;
        switch (op) {
            case '+': result = num1 + num2; break;
            case '-': result = num1 - num2; break;
            case '*': result = num1 * num2; break;
            case '/': result = num2 != 0 ? num1 / num2 : 0;
                      if (num2 == 0) System.out.println("Cannot divide by zero.");
                      break;
            default: System.out.println("Invalid operator.");
                     return;
        }

        System.out.println("Result: " + result);
    }
}
