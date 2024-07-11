import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import Sunlit.exceptions.*;

class BankOnlineTest {

    @Test
    void sendNullArgumentTest() {
        Assertions.assertThatThrownBy(() -> new BankOnline().send(null, 50.0)).isInstanceOf(NullArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("5343765398129847", null)).isInstanceOf(NullArgumentException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send(null, null)).isInstanceOf(NullArgumentException.class);
    }

    @Test
    void sendInvalidCardNumberTest() {
        Assertions.assertThatThrownBy(() -> new BankOnline().send("775", 775.0)).isInstanceOf(InvalidCardNumberException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("S999999999000000", 9009.0)).isInstanceOf(InvalidCardNumberException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("77777777777777_8", 100.0)).isInstanceOf(InvalidCardNumberException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("7777777HYT555555", 5555.0)).isInstanceOf(InvalidCardNumberException.class);
    }

    @Test
    void sendInvalidTransferValueTest() {
        Assertions.assertThatThrownBy(() -> new BankOnline().send("4332492027670223", -50.0)).isInstanceOf(InvalidTransferValueException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("4332492027670223", 0.0)).isInstanceOf(InvalidTransferValueException.class);
    }

    @Test
    void sendCardBlockedTest() {
        Assertions.assertThatThrownBy(() -> new BankOnline().send("1111111111111111", 5000.0)).isInstanceOf(CardBlockedException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("2222222222222222", 5000.0)).isInstanceOf(CardBlockedException.class);
        Assertions.assertThatThrownBy(() -> new BankOnline().send("3333333333333333", 5000.0)).isInstanceOf(CardBlockedException.class);
    }

    @Test
    public void outOfLimitTransferExceptionTest () {
        Assertions.assertThatThrownBy(() -> new BankOnline().send("9999999999999999", 50001.0)).isInstanceOf(OutOfLimitTransferException.class);

    }
}