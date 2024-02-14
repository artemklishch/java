import org.example.AuthenticationService;
import org.example.exceptions.AuthenticationException;

import java.io.File;
import java.nio.file.Files;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws AuthenticationException {

        String content = readFil();

        AuthenticationService service = new AuthenticationService();
        service.authenticate(null, "123");
    }

    private static String readFil() {
        File file = new File("lines.txt");
        try {
            return Files.readString(file.toPath());
        } catch (IOException e) {
            return "";
        }
    }
}