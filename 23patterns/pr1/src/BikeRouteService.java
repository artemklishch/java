public class BikeRouteService implements RouteService {

    @Override
    public double calculateRoute(int startPoint, int endPoint) {
        return (double) (endPoint - startPoint) / 20;
    }
}
