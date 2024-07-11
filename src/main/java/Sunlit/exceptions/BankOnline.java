package sunlit.exceptions;
import java.util.*;

public class BankOnline {

    public final static int TRANSFER_LIMIT = 50000;
    private final static double CARD_LENGTH = 16;
    private final static List<String> BLOCKED_CARDS = Arrays.asList(
            "1111111111111111",
            "2222222222222222",
            "3333333333333333"
    );

    public void send(String cardNumber, Double money) throws InvalidCardNumberException, NullArgumentException, CardBlockedException, InvalidTransferValueException, OutOfLimitTransferException {
        if (cardNumber == null || money == null) {
            throw new NullArgumentException();
        }

        if (cardNumber.length() != CARD_LENGTH || !isTheCardNumberValid(cardNumber)) {
            throw new InvalidCardNumberException(cardNumber);
        }

        if (BLOCKED_CARDS.contains(cardNumber))
        {
            throw new CardBlockedException();
        }

        if (money > TRANSFER_LIMIT)
        {
            throw new OutOfLimitTransferException(TRANSFER_LIMIT);
        }

        if (money <= 0) {
            throw new InvalidTransferValueException();
        }
    }

    private boolean isTheCardNumberValid(String card) {
        try {
            Double.parseDouble(card);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }

}
