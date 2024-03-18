import java.util.Arrays;
import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        int number = 1234;
        Integer n = (Integer) number;
        String[] nums = n.toString().split("");
        int[] reversedNums = new int[nums.length];
        int counter = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            reversedNums[counter] = Integer.valueOf(nums[i]);
            counter++;
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(reversedNums));

        String str1 = "azyxxzyzy";
        String substr = "zy";

        System.out.println(str1.indexOf(substr));
        System.out.println(str1.substring(str1.indexOf(substr) + substr.length()));

        System.out.println(str1.matches(substr));

        String temp = str1.replace(substr, "");
        int occ = (str1.length() - temp.length()) / substr.length();
        System.out.println(temp);
        System.out.println(occ);

        Map<Integer, String> myHashMap = new HashMap<>();
        myHashMap.put(16, "hi 1");
        myHashMap.put(32, "hi 2");
        myHashMap.put(null, "hi 3");
        Object v = myHashMap.get(32);
        System.out.println(v);
    }
}