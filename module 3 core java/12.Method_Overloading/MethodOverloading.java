public class MethodOverloading {
    // Method with two integer parameters
    int add(int a, int b) {
        return a + b;
    }

    // Method with two double parameters
    double add(double a, double b) {
        return a + b;
    }

    // Method with three integer parameters
    int add(int a, int b, int c) {
        return a + b + c;
    }

    public static void main(String[] args) {
        MethodOverloading mo = new MethodOverloading();

        System.out.println("Sum of two integers: " + mo.add(5, 10));
        System.out.println("Sum of two doubles: " + mo.add(5.5, 10.5));
        System.out.println("Sum of three integers: " + mo.add(5, 10, 15));
    }
}
