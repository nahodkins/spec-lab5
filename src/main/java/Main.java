import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Number of words: ");
        int wordsNumber = scanner.nextInt();
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, wordsNumber)
                .mapToObj(i -> scanner.next())
                .forEach(string -> {
                    builder.append(string).append(" ");
                    System.out.println("Current length: " + builder.length());
                    System.out.println("Current builder content: "  + builder);
                });
        System.out.println("Result: " + builder);
    }
}
