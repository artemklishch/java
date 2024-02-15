import java.io.File;
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
        } catch(IOException e){
            throw new RuntimeException("Can't create file", e);
        }
    }
}