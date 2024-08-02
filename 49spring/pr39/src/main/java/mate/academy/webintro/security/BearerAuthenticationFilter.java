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

@Component
@RequiredArgsConstructor
public class BearerAuthenticationFilter extends HttpFilter {
    private final TokenUtil tokenUtil;

    private static final String AUTHORIZATION_SCHEMA_BEARER = "Bearer";

    @Override
    protected void doFilter(
            HttpServletRequest request,
            HttpServletResponse response,
            FilterChain chain
    ) throws IOException, ServletException {
        String token = extractToken(request);
        if (token != null && tokenUtil.isValidToken(token)) {
            String username = tokenUtil.extractUsername(token);
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                    username, null // we pass null, because in this case it is not mandatory
                    // we know that user has been authenticated and at the moment and we use token - and token is enough
                    // for this way of authentication checkout
            );
            SecurityContextHolder.getSecurityContext().setAuthentication(authenticationToken);
        }
        chain.doFilter(request, response);
    }

    private String extractToken(HttpServletRequest request) {
        String header = request.getHeader("Authorization");
        if (header == null || header.isEmpty()) {
            return null;
        }
        header = header.trim();
        if (!StringUtils.startsWithIgnoreCase(header, AUTHORIZATION_SCHEMA_BEARER)) {
            return null;
        }
        if (header.equalsIgnoreCase(AUTHORIZATION_SCHEMA_BEARER)) {
            throw new BadCredentialException("Empty bearer authentication token");
        }
        String token = header.substring(7);
        return token;
    }

    // 1. add method generateToken(String username)
    // 2. send this toke to the client ??? when and how?
    // 3. receive token from the client
    // 4. validate token and identify client


}
