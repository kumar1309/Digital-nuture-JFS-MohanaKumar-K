import java.util.Scanner;

public class ArraySumAverage {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        int n = input.nextInt();

        int[] numbers = new int[n];
        int sum = 0;

        // Reading array elements
        for (int i = 0; i < n; i++) {
            System.out.print("Enter element #" + (i + 1) + ": ");
            numbers[i] = input.nextInt();
            sum += numbers[i];
        }

        double average = (double) sum / n;

        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
    }
}
