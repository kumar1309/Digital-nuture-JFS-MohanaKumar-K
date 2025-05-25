import java.util.ArrayList;
import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        String input;

        System.out.println("Enter student names (type 'stop' to end):");
        while (!(input = scanner.nextLine()).equalsIgnoreCase("stop")) {
            students.add(input);
        }

        System.out.println("Student Names:");
        for (String name : students) {
            System.out.println(name);
        }
    }
}
