package hm_seminar3;
import hm_seminar3.exceptions.NotEnoughProductException;
import hm_seminar3.exceptions.OrderException;
import hm_seminar3.exceptions.ProductFinishException;
import java.sql.SQLException;

public class ShopManager {

    public static double purchaseProduct(int productId, int quantity) throws OrderException, SQLException, ProductFinishException, ClassNotFoundException {
        Product product = ProductDatabase.getProduct(productId);


        if (product == null) {
            throw new OrderException("Product not found");
        }

        if (product.getAvailableQuantity() == 0) {
            throw new ProductFinishException("Product is finished");
        }

        System.out.println(product);
        double totalPrice = product.getPrice() * quantity;
        return totalPrice;
    }

    // Метод, запускающийся при совершении покупки, вычисляет новое количество товара и передает в базу данных.

    public static int purchase(int productId, int quantity) throws SQLException, ClassNotFoundException, NotEnoughProductException {
        Product product = ProductDatabase.getProduct(productId);
        int result = product.bye(quantity);
        product = ProductDatabase.newDBsingle(productId, result);
        return result;
    }
}
