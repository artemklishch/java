import java.lang.String;
import java.lang.Character;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;
import java.lang.StringBuilder;
import java.util.Collections;

public class Main {
    private static final int LIMIT_NUMBER = 5;

    public static void main(String[] args) {
        String uniqueCharacters = getUniqueCharacters("zBk yAz b-kN,hdWi ?io,wjKo wl -l");
        System.out.println(uniqueCharacters);
        List<String> arr = new ArrayList<>();
        arr.add("c");
        arr.add("z");
        arr.add("a");
//        System.out.println(Collections.sort(arr));
    }

    private static String getUniqueCharacters(String text) {
        Set<String> uniqueLetters = new TreeSet<>();
        for (Character letter : text.toCharArray()) {
            boolean isLetter = Character.isLetter(letter);
            if (isLetter) {
                String lowerCaseLetter = String.valueOf(letter).toLowerCase();
                uniqueLetters.add(lowerCaseLetter);
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String letter : uniqueLetters) {
            stringBuilder.append(letter);
        }
        String result = stringBuilder.toString();
        if (result.length() > LIMIT_NUMBER) {
            return result.substring(0, LIMIT_NUMBER);
        }
        return result;
    }
}