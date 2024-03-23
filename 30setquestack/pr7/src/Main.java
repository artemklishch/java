import java.util.Set;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        Set<Integer> str1 = new HashSet<>();
        str1.add(1);
        str1.add(2);
        str1.add(3);
        Set<Integer> str2 = new HashSet<>();
        str2.add(2);
        str2.add(3);
        str2.add(4);

//        System.out.println(str1);
//        System.out.println(str2);
//
//        System.out.println(str2.retainAll(str1));
//
//        System.out.println(str1);
//        System.out.println(str2);

        Set<Integer> resukt = symmetricDifference(str1, str2);
//        System.out.println(resukt);
    }

    private static Set<Integer> symmetricDifference(Set<Integer> set1, Set<Integer> set2) {
        if (set1 == null || set1.isEmpty()) {
            return new HashSet<>(set2);
        }
        if (set2 == null || set2.isEmpty()) {
            return new HashSet<>(set1);
        }
        if (set1.isEmpty() && set2.isEmpty()) {
            return new HashSet<>();
        }
        Set<Integer> resultSet = new HashSet<>();
        resultSet.addAll(set1);
        resultSet.addAll(set2);

        Set<Integer> allValuesToRetain = new HashSet<>();
        allValuesToRetain.addAll(set1);
        allValuesToRetain.addAll(set2);
        allValuesToRetain.retainAll(set1);
        allValuesToRetain.retainAll(set2);

        resultSet.removeAll(allValuesToRetain);

        return resultSet;
    }

}