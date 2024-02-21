//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        RouteStrategy strategy = new RouteStrategy();
        RouteService bikeRouteService = strategy.getRouteService("bike");
        double time = bikeRouteService.calculateRoute(0, 100);
        System.out.println(time);
    }
}