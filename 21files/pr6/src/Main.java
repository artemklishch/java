import java.io.*;
import java.util.List;
import java.nio.file.Files;

// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file1 = new File("cars.txt");
//        try {
//            file1.createNewFile();
//        } catch (IOException e) {
//            throw new RuntimeException("no file created", e);
//        }
        try {
            List<String> strings = Files.readAllLines(file1.toPath());
            System.out.println(strings);
        } catch (IOException e) {
            throw new RuntimeException("an't read file", e);
        }
    }
}