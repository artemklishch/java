import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        // Map
        Map<String, String> capitalCities = new HashMap<>();
        capitalCities.put("England", "London");
        capitalCities.put("Germany", "Berlin");
        capitalCities.put("Norway", "Oslo");
        capitalCities.put("Ukraine", "Kyiv");
        System.out.println(capitalCities);

        Map<String, Integer> population = new HashMap<>();
        population.put("Ukraine", 35_000_000);
        String ukraineCapital = capitalCities.get("Ukraine");
        Integer ukrainePopulation = population.get("Ukraine");
        System.out.println(ukraineCapital);
        System.out.println(ukrainePopulation);

        System.out.println(capitalCities.keySet());
        System.out.println(capitalCities.values());
    }
}