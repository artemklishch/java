package mate.academy.webintro.security;

import java.util.List;

public class PublicAvailableEndpoints {
    private static final List<String> publicEndpoints = List.of(
            "/auth/login", // or "/api/auth/login"
            "/auth/registration"
    );

    public static List<String> getPublicEndpoints() {
        return publicEndpoints;
    }
}
