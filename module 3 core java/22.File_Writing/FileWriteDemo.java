import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileWriteDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a message: ");
        String message = scanner.nextLine();

        try (FileWriter writer = new FileWriter("output.txt")) {
            writer.write(message);
            System.out.println("Message written to output.txt successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}
