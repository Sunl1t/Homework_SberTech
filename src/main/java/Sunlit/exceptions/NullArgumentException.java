package sunlit.exceptions;

public class NullArgumentException extends BankOnlineException {
    public NullArgumentException() {
        super("Одно или несколько полей null!");
    }
}
