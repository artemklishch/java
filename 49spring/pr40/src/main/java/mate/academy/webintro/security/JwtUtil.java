package mate.academy.webintro.security;//package mate.academy.webintro.security;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jws;
//import io.jsonwebtoken.JwtException;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.security.Keys;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Component;
//
//import javax.crypto.SecretKey;
//import java.nio.charset.StandardCharsets;
//import java.security.Key;
//import java.util.Date;
//import java.util.function.Function;
//
//@Component
//public class JwtUtil {
//    private final Key secret;
//
//    @Value("${jwt.expiration}")
//    private long expiration;
//
//    public JwtUtil(@Value("${jwt.secret}") String secretString) {
//        if (secretString == null || secretString.isEmpty()) {
//            throw new IllegalArgumentException("Secret string cannot be null or empty");
//        }
//        this.secret = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
//    }
//
//    public String generateToken(String username) {
//        return Jwts.builder()
//                .setSubject(username)
//                .setIssuedAt(new Date(System.currentTimeMillis()))
//                .setExpiration(new Date(System.currentTimeMillis() + expiration))
//                .signWith(secret)
//                .compact();
//    }
//
//    public boolean isValidToken(String token) {
//        try {
//            Jws<Claims> claimsJws = Jwts.parser()
//                    .setSigningKey(secret)
//                    .build()
//                    .parseClaimsJws(token);
//            return !claimsJws.getBody().getExpiration().before(new Date());
//        } catch (JwtException | IllegalAccessError e) {
//            throw new JwtException("Expired or invalid JWT token");
//        }
//    }
//
//    public String getUsername(String token) {
//        return getClaimFromToken(token, Claims::getSubject);
//    }
//
//    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
//        final Claims claims = Jwts.parser()
//                .setSigningKey(secret)
//                .build()
//                .parseClaimsJws(token).getBody();
//        return claimsResolver.apply(claims);
//    }
//}


import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.function.Function;
import javax.crypto.SecretKey;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {
    private final SecretKey secret; // використовуємо SecretKey, а не Key

    @Value("${jwt.expiration}")
    private long expiration;

    public JwtUtil(@Value("${jwt.secret}") String secretString) {
        secret = Keys.hmacShaKeyFor(secretString.getBytes(StandardCharsets.UTF_8));
    }

    public String generateToken(String username) {
        return Jwts.builder()
                .subject(username) // subjet, а не setSubject
                .issuedAt(new Date(System.currentTimeMillis())) // issuedAt, а не setIssuedAt
                .expiration(new Date(System.currentTimeMillis() + expiration))  // expiration, а не setExpiration
                .signWith(secret)
                .compact();
    }

    public boolean isValidToken(String token) {
        try {
            Jws<Claims> claimsJws = Jwts.parser()
                    .verifyWith(secret) // verifyWith, а не setSigningKey
                    .build()
                    .parseSignedClaims(token); // parseSignedClaims, а не parseClaimsJws

            return !claimsJws.getPayload().getExpiration().before(new Date()); // getPayload(), а не getBody()
        } catch (JwtException | IllegalArgumentException e) {
            throw new JwtException("Expired or invalid JWT token");
        }
    }

    public String getUsername(String token) {
        return getClaimFromToken(token, Claims::getSubject);
    }

    private <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = Jwts.parser()
                .verifyWith(secret)
                .build()
                .parseSignedClaims(token)
                .getPayload();
        return claimsResolver.apply(claims);
    }
}
