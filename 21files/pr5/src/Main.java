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
            StringBuilder builder = new StringBuilder();
            String value = bufferedReader.readLine();
            while (value != null) {
                builder.append(value).append(System.lineSeparator());
                value = bufferedReader.readLine();
            }
            System.out.println(builder.toString());
        } catch (IOException e) {
            throw new RuntimeException("can't read file", e);
        }
    }
}