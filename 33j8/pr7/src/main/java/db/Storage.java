package db;

import model.Advertisement;
import model.Car;
import model.User;

import java.util.List;
import java.util.ArrayList;

public class Storage {
    public static List<Advertisement> getAdvertisements() {
        List<Advertisement> advertisements = new ArrayList<>();

        User bob = new User("Bob", "+380467894");
        User alice = new User("Alice", "+3804678794");
        User john = new User("John", "+380467890");

        Advertisement camry = new Advertisement(bob, new Car("Toyota", "Camry", 2011));
        Advertisement corolla = new Advertisement(bob, new Car("Toyota", "Corolla", 2018));
        Advertisement yaris = new Advertisement(bob, new Car("Toyota", "Yaris", 2020));
        Advertisement accord = new Advertisement(alice, new Car("Honda", "Accord", 2018));
        Advertisement matiz = new Advertisement(john, new Car("Daewoo", "Matiz", 2008));
        Advertisement lanos = new Advertisement(john, new Car("Daewoo", "Lanos", 2017));

        advertisements.add(camry);
        advertisements.add(corolla);
        advertisements.add(yaris);
        advertisements.add(accord);
        advertisements.add(matiz);
        advertisements.add(lanos);

        return advertisements;
    }

}
