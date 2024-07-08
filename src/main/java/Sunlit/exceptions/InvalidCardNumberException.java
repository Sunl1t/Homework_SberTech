package Sunlit.exceptions;

public class InvalidCardNumberException extends BankOnlineException {
    public InvalidCardNumberException(String message) {
        super("Недействительный номер карты: " + message);
    }
}
