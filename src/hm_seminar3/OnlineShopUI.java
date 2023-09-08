package hm_seminar3;
import hm_seminar3.exceptions.InputErrorException;
import hm_seminar3.exceptions.NotEnoughProductException;
import hm_seminar3.exceptions.OrderException;
import hm_seminar3.exceptions.ProductFinishException;
import java.sql.SQLException;
import java.util.Scanner;

public class OnlineShopUI {
    public static void main(String[] args) throws InputErrorException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter product ID: ");
        int productId = scanner.nextInt();
        System.out.print("Enter quantity: ");
        int quantity = scanner.nextInt();

        try {
            double totalPrice = ShopManager.purchaseProduct(productId, quantity);
            System.out.println("Total price: $" + totalPrice);
        } catch (OrderException | ProductFinishException e) {
            System.out.println(e.getMessage());
        } catch (SQLException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        System.out.print("Купить?(yes / no)");
        String answer = scanner.next();
        if (!answer.equals("yes")) {
            while (!answer.equals("yes")) {
                try {
                    System.out.print("Купить?(yes / no)");
                    answer = scanner.next();
                    throw new InputErrorException("Input exception");
                } catch (InputErrorException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        scanner.close();
        if (answer.equals("yes")) {
            int result = 0;
            try {
                result = ShopManager.purchase(productId, quantity);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            } catch (NotEnoughProductException e) {
                throw new RuntimeException(e.getMessage());
            }
            System.out.println("The rest of the goods in stock: " + result);
        }
    }
}
