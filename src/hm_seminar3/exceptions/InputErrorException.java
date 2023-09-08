package hm_seminar3.exceptions;

// Ошибка ввода данных от пользователя при совершении покупки

public class InputErrorException extends Exception{
    public InputErrorException(String message) {
        super(message);
    }
}
