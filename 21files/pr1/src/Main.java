import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            File file = new File("test.txt");
            file.createNewFile();

            File folder = new File("myFolder");
            folder.mkdir();
            String filePath = "myFolder" + File.separator + "hello.txt";
            File file1 = new File(filePath);
            file1.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }

        String[] users = {"Bob", "Alice", "John"};
        File file2 = new File("users.txt");
        for (String user : users) {
//            BufferedWriter bufferedWriter = null;
//            try {
//                bufferedWriter = new BufferedWriter(new FileWriter(file2, true)); // second argument is to add text to the existing text, not to overwrite
//                bufferedWriter.write(user);
//            } catch (IOException e) {
//                throw new RuntimeException("Can't write data to file.", e);
//            } finally {
//                try {
//                    bufferedWriter.close();
//                } catch (IOException e) {
//                    throw new RuntimeException(e);
//                }
//            }
            try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file2, true))) {
                bufferedWriter.write(user);
            } catch (IOException e) {
                throw new RuntimeException("Can't write data to file.", e);
            }
        }
    }
}