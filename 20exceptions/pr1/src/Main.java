import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    //    public static void main(String[] args) throws IOException {
////        String str1 = null;
////        System.out.println(str1.toUpperCase());
//
//        File file = new File("lines.txt");
//        String content = Files.readString(file.toPath());
//    }
    public static void main(String[] args) {
        File file = new File("lines.txt");
        try {
            String content = Files.readString(file.toPath());
        } catch (IOException err) {
            System.out.println("Error occured " + err);
        }
    }
}