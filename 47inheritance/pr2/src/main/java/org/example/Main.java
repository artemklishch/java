package org.example;

import org.example.dao.MachineDao;
import org.example.dao.impl.MachineDaoImpl;
import org.example.model.ElectricCar;
import org.example.model.Machine;
import org.example.model.RacingCar;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        MachineDao machineDao = new MachineDaoImpl();

        Machine volvoTruck = new Machine();
        volvoTruck.setName("Volvo Truck");
        volvoTruck.setPrice(BigDecimal.valueOf(55999));
        machineDao.save(volvoTruck);

        ElectricCar tesla = new ElectricCar("Tesla", BigDecimal.valueOf(31999), 0.98);
        RacingCar ferrari = new RacingCar("Ferrari", BigDecimal.valueOf(87999), 500);
        machineDao.save(tesla);
        machineDao.save(ferrari);
    }
}