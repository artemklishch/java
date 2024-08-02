package mate.academy.webintro.security;

public interface Authentication {
    Object getPrincipal();

    Object getCredentials();
}
