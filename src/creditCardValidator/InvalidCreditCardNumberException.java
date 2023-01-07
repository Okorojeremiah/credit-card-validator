package creditCardValidator;

public class InvalidCreditCardNumberException extends RuntimeException {

    public InvalidCreditCardNumberException(String message) {
        super(message);
    }
}
