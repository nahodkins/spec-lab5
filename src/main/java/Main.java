import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Start program:");
        Scanner scanner = new Scanner(System.in);
        System.out.print("File: ");
        String filePath = scanner.next();
        HexDumpConverter
                .convertFileToHexDump(new File(filePath));
    }
}
