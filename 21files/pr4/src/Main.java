import java.io.*;

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
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file1));
//            System.out.println(bufferedReader.readLine());
            StringBuilder builder = new StringBuilder();
            int value = bufferedReader.read();
            while (value != -1) {
                builder.append((char) value);
                value = bufferedReader.read();
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("can't read file", e);
        }
    }
}