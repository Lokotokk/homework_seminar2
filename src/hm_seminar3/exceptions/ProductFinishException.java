package hm_seminar3.exceptions;

// Ошибка, если запрашиваемый товар закончился

public class ProductFinishException extends Exception{
    public ProductFinishException(String message) {
        super(message);
    }
}
