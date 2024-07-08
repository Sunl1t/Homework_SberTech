package Sunlit.exceptions;

public class OutOfLimitTransferException extends BankOnlineException {
    public OutOfLimitTransferException(Integer limit) {
        super(String.format("Превышен лимит переводов: " + limit));
    }
}
