package Sunlit.exceptions;

public class CardBlockedException extends BankOnlineException {
    public CardBlockedException() {
        super("Card has been blocked!");
    }
}
