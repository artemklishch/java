package org.example;

import org.example.dao.AddressDao;
import org.example.dao.UserDao;
import org.example.dao.impl.AddressDaoImpl;
import org.example.dao.impl.UserDaoImpl;
import org.example.model.Address;
import org.example.model.User;

public class Main {
    public static void main(String[] args) {
        User bob = new User();
        bob.setUserName("Bob");
        UserDao userDao = new UserDaoImpl();
        userDao.save(bob);


        Address bobAddress = new Address();
        bobAddress.setCity("Kyiv");
        bobAddress.setStreet("Shevchenka st.");
        bobAddress.setUser(bob);
        AddressDao addressDao = new AddressDaoImpl();
        addressDao.save(bobAddress);

        User bobFromDB = userDao.get(1L);
        System.out.println(bobFromDB);
    }
}