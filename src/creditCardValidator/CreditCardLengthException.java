package creditCardValidator;

public class CreditCardLengthException extends RuntimeException{
    public CreditCardLengthException(String message) {
        super(message);
    }
}
