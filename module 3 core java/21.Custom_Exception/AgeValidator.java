// Custom Exception Example
class InvalidAgeException extends Exception {
    public InvalidAgeException(String message) {
        super(message);
    }
}

public class AgeValidator {
    public static void main(String[] args) {
        int age = 16; // you can take input as well
        try {
            if (age < 18) {
                throw new InvalidAgeException("Age is below 18. Access Denied.");
            } else {
                System.out.println("Access Granted.");
            }
        } catch (InvalidAgeException e) {
            System.out.println("Caught Exception: " + e.getMessage());
        }
    }
}
