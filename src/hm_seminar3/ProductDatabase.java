package hm_seminar3;

import java.sql.*;


public class ProductDatabase {
    public static final String USER_NAME = "root";
    public static final String PASSWORD = "forTeach23";
    public static final String URL = "jdbc:mysql://localhost:3306/mysql";
    public static Statement statement;
    public static Connection connection;

    // метод, возвращающий продукт из базы данных по введенному ID.

    public static Product getProduct(int productId) throws SQLException, ClassNotFoundException {
        Product product = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT * FROM online_shop.products");
            while(result.next()) {
                if (result.getInt("ID") == productId) {
                    String name = result.getString("name");
                    int availableQuantity = result.getInt("availableQuantity");
                    double price = result.getInt("price");
                    product = new Product(name, availableQuantity, price);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("Connection error. Try again later");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Internal error. Try again later");
        }
        return product;
    }

    // метод, обновляющий данные о доступном количестве товара при совершении покупки.

    public static Product newDBsingle (int productId, int quantity) throws SQLException, ClassNotFoundException {
        Product product = getProduct(productId);
        String sql = "UPDATE online_shop.products SET availableQuantity=? WHERE id=?";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, quantity);
        statement.setInt(2, productId);
        int rowsUpdated = statement.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("The data has been successfully updated!");
        }
        return product;
    }
}





