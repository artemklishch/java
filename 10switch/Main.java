public class Main {
    public static void main(String[] args) {
        String maturnity = "adult";
        switch (maturnity) {
            case "child": {
                System.out.println("I want to play");
                break;
            }
            case "adult": {
                System.out.println("I want to work");
                break;
            }
            default: {
                System.out.println("I want to dance");
            }
        }

        String activity = "math";
        switch (activity) {
            case "math":
            case "physics":
            case "chemistry": {
                System.out.println("SCIENCE");
                break;
            }
            case "football":
            case "bascetball":
            case "tennis": {
                System.out.println("SPORT");
                break;
            }
            case "walking":
            case "watching TV": {
                System.out.println("HOBBY");
                break;
            }
        }

        switch (3) {
            case 1:
                System.out.println("Monday");
            case 2:
                System.out.println("Tuesday");
            case 3:
                System.out.println("Wednesday");
            case 4:
                System.out.println("Thursday");
            case 5:
                System.out.println("Friday");
            case 6:
                System.out.println("Saturday");
            case 7:
                System.out.println("Sunday");
            default:
                System.out.println("Incorrect input data");
        }
    }

}