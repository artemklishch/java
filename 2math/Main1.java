public class Main1 {
    public static void main(String[] args) {
        int candies = 11;
        int persons = 3;
        int result = candies / persons;
        System.out.println(result);

        int remainder = candies % persons; // this is not typical devision by module - in this case we get the remains,
                                           // that aren't included to integer part
        System.out.println("remainder: " + remainder);

        System.out.println("------");

        int candies1 = 10;
        candies1 += 5;
        System.out.println(candies1);

        System.out.println("------increment");
        int count = 20;
        System.out.println(count);
        count++;
        System.out.println(count);

        System.out.println("------decrement");
        int count1 = 20;
        System.out.println(count1);
        count1--;
        System.out.println(count1);
    }
}