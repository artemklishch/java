package mate.academy.webintro.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TestController {

    @Value("${jwt.secret}")
    private String jwtSecret;

    @GetMapping("/test")
    public String test() {
        return "JWT Secret: " + jwtSecret;
    }
}
