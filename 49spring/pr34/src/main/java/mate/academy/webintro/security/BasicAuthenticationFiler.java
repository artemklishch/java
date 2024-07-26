package mate.academy.webintro.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mate.academy.webintro.exception.BadCredentialException;
import mate.academy.webintro.service.Authentication;
import mate.academy.webintro.service.UsernamePasswordAuthenticationToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@Component
public class BasicAuthenticationFiler extends HttpFilter {
    private static final String AUTHORIZATION_SCHEMA_BASIC = "basic";

    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        // 1. fetch header value
        // 2. parse token into login and password
        // 3. save information about currently logged user int Security context
        // 6. in OrderController use info SecurityContext

        String url = request.getRequestURI();
        if (PublicAvailableEndpoints.getPublicEndpoints().contains(url)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication authentication = getAuthentication(request);
        chain.doFilter(request, response);
    }

    private Authentication getAuthentication(HttpServletRequest request) {
        String header = request.getHeader("Authorization"); // "Basic Ym9iQGdtYWlsLmNvbToxMjM0"
        if (header == null || header.isEmpty()) {
            return null;
        }
        header = header.trim();
        if (!StringUtils.startsWithIgnoreCase(header, AUTHORIZATION_SCHEMA_BASIC)) {
            return null;
        }
        if (header.equalsIgnoreCase(AUTHORIZATION_SCHEMA_BASIC)) {
            throw new BadCredentialException("Empty basic authentication token");
        }
        String token = header.substring(6);
        byte[] decodedToken = Base64.getDecoder().decode(token);
        String loginAndPassword = new String(decodedToken); // bob@gmail.com:1234
        int delim = loginAndPassword.indexOf(':');
        if (delim == -1) {
            throw new BadCredentialException("Invalid basic authentication token");
        }
        String login = loginAndPassword.substring(0, delim);
        String password = loginAndPassword.substring(delim + 1);
        return new UsernamePasswordAuthenticationToken(login, password);
    }
}
