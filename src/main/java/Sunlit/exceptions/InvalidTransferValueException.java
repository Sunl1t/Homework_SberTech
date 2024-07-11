package sunlit.exceptions;

public class InvalidTransferValueException extends BankOnlineException {
    public InvalidTransferValueException() {
        super("Некорректная сумма");
    }
}
