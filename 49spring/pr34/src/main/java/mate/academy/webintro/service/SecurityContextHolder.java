package mate.academy.webintro.service;

public class SecurityContextHolder {
    // ThreadLocal класс потрібний для того, щоб інформація про мноєинних користувачів,
    // які користуються порграммою,не перетиналась
    // цей клас походить від багнатопоточностей
    // суть класу: ми можему використовувати його як обгортку для статичних об'єктів і доступ до яких
    // повинен бути в рамках всього додатку і в рамках якогось потоку

//    private static final ThreadLocal<SecurityContext> securityContext = new ThreadLocal<>() {
//        @Override
//        protected SecurityContext initialValue() {
//            return new SecurityContext();
//        }
//    };

    private static final ThreadLocal<SecurityContext> securityContext = ThreadLocal
            .withInitial(SecurityContext::new);

    public static SecurityContext getSecurityContext() {
        return securityContext.get();
    }
}
