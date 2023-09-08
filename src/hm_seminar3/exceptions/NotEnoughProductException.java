package hm_seminar3.exceptions;

// Ошибка, если нельзя совершить покупку из - за отсутствия требуемого количества товара на складе.

public class NotEnoughProductException extends Exception{
    public NotEnoughProductException(String message) {
        super(message);
    }
}
