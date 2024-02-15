import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        String[] users = {"Bob", "Alice", "John"};
        File file2 = new File("users.txt");
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(file2, true)); // second argument is to add text to the existing text, not to overwrite
            for (String user : users) {
                bufferedWriter.write(user);
                bufferedWriter.flush(); // without it no data after iteration, just after all iterations, after expressoin with 'close()' method
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write data to file.", e);
        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

    }
}