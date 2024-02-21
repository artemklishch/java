public class RouteStrategy {
    public RouteService getRouteService(String transportType) {
        switch (transportType) {
            case "bike":
                return new BikeRouteService();
            case "walk":
                return new WalkingRouteService();
            case "public":
                return new PublicTransportRouteService();
            case "car":
            default:
                return new CarRouteService();
        }
    }
}
