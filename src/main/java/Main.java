import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String copyFrom = args[0];
        String copyTo = args[1];
        FileCopier copier = new FileCopier();
        try {
            copier.copyFiles(copyFrom, copyTo);
            System.out.println("File was copied successfully!");
        } catch (FileCopierException e) {
            System.out.println("Copy was failed!");
            e.printStackTrace();
        }
    }
}
