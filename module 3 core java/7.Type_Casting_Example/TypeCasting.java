public class TypeCasting {
    public static void main(String[] args) {
        double myDouble = 9.78;
        int myInt = (int) myDouble; // narrowing

        int anotherInt = 7;
        double anotherDouble = anotherInt; // widening

        System.out.println("Double to Int: " + myInt);
        System.out.println("Int to Double: " + anotherDouble);
    }
}
