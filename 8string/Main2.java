public class Main2 {
    public static void main(String[] args) {
        String password = "password=abc123";
        String login = "logon=bob";
        String passwordValue = getValue(password);
        String loginValue = getValue(login);

        System.out.println(passwordValue);
        System.out.println(loginValue);
    }

    public static String getValue(String input) {
        int index = input.indexOf('=');
        return input.substring(index + 1);
    }
}