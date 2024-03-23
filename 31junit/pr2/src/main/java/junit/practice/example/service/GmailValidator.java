package junit.practice.example.service;

public class GmailValidator implements EmailValidator {
    @java.lang.Override
    public boolean isValid(java.lang.String email) {
//        if (email == null) {
//            return false;
//        }
        if (!Character.isLetter(email.charAt(0))) {
            return false;
        }
        return true;
    }
}
