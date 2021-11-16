import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        try (MyCloseable myCloseable = new MyCloseable()){
            System.out.println("try block");
        } finally {
            System.out.println("finally block");
        }
    }
}
