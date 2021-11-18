import java.io.*;
import java.util.stream.Collectors;

public class FileCopier {

    private String readFile(File file) throws FileCopierException {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))){
            return reader.lines().collect(Collectors.joining("\n"));
        } catch (IOException e) {
            throw new FileCopierException(e);
        }
    }

    private void writeFile(File file, String source) throws FileCopierException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            writer.write(source);
        } catch (IOException e) {
            throw new FileCopierException(e);
        }
    }

    private File checkDirectoryPresent(String directoryPath) {
        File file = new File(directoryPath);
        File parentFile = file.getParentFile();
        if (parentFile != null && !parentFile.exists()) {
            parentFile.mkdirs();
        }
        return file;
    }

    public void copyFiles(String pathFrom, String pathTo) throws FileCopierException {
        String content = readFile(new File(pathFrom));
        File saveToFile = checkDirectoryPresent(pathTo);
        writeFile(saveToFile, content);
    }
}
