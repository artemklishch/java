package mate.academy.webintro.exception;

public class BadCredentialException extends RuntimeException {
    public BadCredentialException(String emptyBasicAuthenticationToken) {
        super(emptyBasicAuthenticationToken);
    }
}
