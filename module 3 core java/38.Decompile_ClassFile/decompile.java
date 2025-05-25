public class decompile {
    public static void main(String[] args) {
        String message=greet("mohan");
        System.out.println(message);
    }
    public static String greet(String name){
        return "hello" + name;
    }
}