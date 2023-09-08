package hm_seminar3.exceptions;

// Ошибка, при введении некорректного ID запрашиваемого товара

public class OrderException extends Exception {
    public OrderException(String message) {
        super(message);
    }
}
