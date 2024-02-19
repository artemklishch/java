import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        File file1 = new File("files/cars.txt");
//        File file1 = new File("/Users/pro/Desktop/development/mine/studing/java/21files/pr7/files/cars.txt");

        System.out.println(file1.exists());
        System.out.println(file1.getPath());
        System.out.println(file1.getAbsolutePath());

        // . ./ ./..

        System.out.println("======= .");
        Path parentDir = Paths.get(".");
        System.out.println(parentDir.toAbsolutePath().toString());
        System.out.println(parentDir.toAbsolutePath());
        System.out.println(parentDir);

        System.out.println("======= ./files");
        Path parentDir1 = Paths.get("./files");
        System.out.println(parentDir1.toAbsolutePath().toString());
        System.out.println(parentDir1);

//        System.out.println("======= ./folder1/folder2.1/folder3.2");
//        Path parentDir2 = Paths.get("./folder1/folder2.1/folder3.2");
        System.out.println("======= ./folder1/folder2.1/folder3.2/../folder3.3");
//        Path parentDir2 = Paths.get("./folder1/folder2.1/folder3.2/../folder3.3");
        Path parentDir2 = Paths.get("./folder1/folder2.1/folder3.2/../..");
        System.out.println(parentDir2.toAbsolutePath().toString());
        System.out.println(parentDir2);

        listFilesForFolder(parentDir2.toFile());
    }

    public static void listFilesForFolder(File folder) {
        for (File fileEntry : folder.listFiles()) {
            System.out.println(
                    "Is directory: "
                            + fileEntry.isDirectory()
                            + ". File name "
                            + fileEntry.getName()
            );
        }
    }
}