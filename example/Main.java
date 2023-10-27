package org.example;

import static org.example.Constants.*;
import java.sql.*;
import java.sql.Connection;

public class Main {

    public void viewProduct() {

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            String selectQuery = "SELECT * FROM store.product";
            try (PreparedStatement preparedStatement = con.prepareStatement(selectQuery);
                ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    int productID = resultSet.getInt("productId");
                    String name = resultSet.getString("name");
                    int price = resultSet.getInt("price");
                    int quantity = resultSet.getInt("quantity");
                    System.out.println("ID : "+productID + ",Name : " + name + ", Prize : " + price + ",Quantity : " + quantity);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        Main main = new Main();
        main.viewProduct();
        System.out.println("Product viewed Successfully");
    }
}