import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Choose exception to throw:");
            System.out.println("1. MyFirstException");
            System.out.println("2. MySecondException");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    throw new MyFirstException("MyFirstException was chosen");
                case 2:
                    throw new MySecondException("MySecondException was chosen");
            }
        } catch (MyFirstException | MySecondException e) {
            try {
                throw new MyThirdException("MyThirdException was thrown", e);
            } catch (MyThirdException ex) {
                ex.printStackTrace();
            }
        }
    }
}
