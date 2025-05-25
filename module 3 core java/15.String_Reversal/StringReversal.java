import java.util.Scanner;

public class StringReversal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String original = input.nextLine();

        String reversed = "";

        // Reversing the string
        for (int i = original.length() - 1; i >= 0; i--) {
            reversed += original.charAt(i);
        }

        System.out.println("Reversed string: " + reversed);
    }
}
