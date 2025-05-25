import java.lang.reflect.Method;

public class ReflectionExample {
    public void hello(String name) {
        System.out.println("Hello, " + name);
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("ReflectionExample");
        Object obj = clazz.getDeclaredConstructor().newInstance();

        Method[] methods = clazz.getDeclaredMethods();
        System.out.println("Methods:");
        for (Method m : methods) {
            System.out.println(m.getName());
        }

        Method helloMethod = clazz.getMethod("hello", String.class);
        helloMethod.invoke(obj, "World");
    }
}
