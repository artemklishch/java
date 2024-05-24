package org.example;

import java.sql.*;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        // 1. load driver
        // 2. connection to database
        // 3. statement
        // 4. handling

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // 1
            Properties dbProperties = new Properties();
            dbProperties.put("user", "artem");
            dbProperties.put("password", "Pssmgk_82");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", dbProperties);// 2

            String sql = "SELECT * FROM car WHERE id = ?";
            PreparedStatement statement = connection.prepareStatement(sql); // підготовлений об'єкт для відправки запиту в БД
            // PreparedStatement - для запиту з динамічними параметрами, Statement - для статичного виразу, без динамічних параметрів
            statement.setLong(1, 1L); // 2
            // перший аргумент - це номе позиції, якщо рахувати по порядку знаки питання в рядку вище
            // другий аргумент - ідентифікатор, тип даних long
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
//            System.out.println(resultSet.getObject(1, Long.class));
//                resultSet.next(); // без цього виникає помилка
                Long id = resultSet.getObject("id", Long.class);
                String model = resultSet.getString("model");
//            int year = resultSet.getInt("year");
                Integer year = resultSet.getObject("year", Integer.class); // це краще, якщо є вірогідність, що значення може дорівнювати null
                System.out.println("Id: " + id);
                System.out.println("Modal: " + model);
                System.out.println("Year: " + year);
            }


        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Can not load JDBC driver", e);
        } catch (SQLException e) {
            throw new RuntimeException("Can not create a connection to the DB", e);
        }
    }
}