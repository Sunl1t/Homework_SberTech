package Sunlit.exceptions;

public class BankOnlineException extends Exception {

    public BankOnlineException(String message) {
        super("Ошибка Банка: \n" + message);
    }
}
