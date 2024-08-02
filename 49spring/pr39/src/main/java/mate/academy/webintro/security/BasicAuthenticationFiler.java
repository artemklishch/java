package mate.academy.webintro.security;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import mate.academy.webintro.exception.BadCredentialException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Base64;

@RequiredArgsConstructor
//@Component
public class BasicAuthenticationFiler extends HttpFilter {
    private static final String AUTHORIZATION_SCHEMA_BASIC = "basic";
    private final AuthenticationManager authenticationManager;

    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        String url = request.getRequestURI();
        if (PublicAvailableEndpoints.getPublicEndpoints().contains(url)) {
            chain.doFilter(request, response);
            return;
        }

        Authentication authentication = getAuthentication(request);
        if (!authenticationManager.isAuthenticated(authentication)) {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return;
        }
        SecurityContextHolder.getSecurityContext().setAuthentication(authentication);
        chain.doFilter(request, response);
    }

    private Authentication getAuthentication(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
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
