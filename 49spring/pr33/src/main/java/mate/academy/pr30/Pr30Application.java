package mate.academy.pr30;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import mate.academy.pr30.dto.CarDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.List;
import java.util.ArrayList;

@SpringBootApplication
public class Pr30Application {
    //    private static final String URL = "https://www.google.com";
    private static final String URL = "http://localhost:8090/cars";

    public static void main(String[] args) throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();

        HttpRequest httpRequest = HttpRequest.newBuilder()
                .GET()
                .uri(URI.create(URL))
                .header("AUTHORIZATION", "Basic Ym9iOjEyMzQ=") // in this case we do authorized request and not logic in the condition down when response status is not equal 200
                .build();

        HttpResponse<String> response = httpClient
                .send(httpRequest, HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
//        List<CarDto> dtos = new ArrayList<>();
        System.out.println(response.body());
        if (response.statusCode() != 200) {
            System.out.println("Response code is " + response.statusCode());
            return;
        }
        ObjectMapper objectMapper = new ObjectMapper();
//        List<CarDto> responseDtos = objectMapper.readValue(
//                response.body(),
//                new TypeReference<List<CarDto>>() {}
//        );
        List<CarDto> responseDtos = objectMapper.readValue(
                response.body(),
                new TypeReference<>() {
                }
        );
        responseDtos.forEach(System.out::println);
    }

}
