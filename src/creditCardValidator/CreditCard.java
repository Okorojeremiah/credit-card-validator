package creditCardValidator;

public class CreditCard {

    public static boolean isValidLength(String cardNumber) {
        boolean isValidLength = cardNumber.length() >= 13 && cardNumber.length() <= 16;
        if (isValidLength) return true;
        throw new CreditCardLengthException("Credit card length must be between 13 and 16 digits");
    }

    public static boolean isValidNumber(String cardNumber) {
        boolean isValidNumber = false;
        for (int i = 0; i < cardNumber.length(); i++){
            if (cardNumber.startsWith("4") || cardNumber.startsWith("5")|| cardNumber.startsWith("6")|| cardNumber.startsWith("37")){
                isValidNumber = true;
            }else {
                throw new InvalidCreditCardNumberException("Credit card number must start with 4 or 5 or 6 or 37");
            }
        }
        return isValidNumber;
    }

    public static long sumOfDoubleEvenDigit(String cardNumber) {
        long sum = 0;
        String value = "";

        for (int i = cardNumber.length() -2; i >= 0; i-=2){
            value = String.valueOf(cardNumber.charAt(i));
            long result = Long.parseLong(value) * 2;
            sum += getResult(result);
        }
        return sum;
    }

    private static long getResult(long result){
        if (result < 9) return result;
        return addResult(result);
    }

    private static long addResult(long result){
        long decimal = result/10;
        long modulo = result%10;
        return decimal + modulo;
    }

    public static long sumOfOddPlaceDigit(String cardNumber) {
        long sum = 0;
        String value = "";
        for (int i = cardNumber.length() - 1; i >= 0; i-=2){
            value = String.valueOf(cardNumber.charAt(i));
            long result = Long.parseLong(value);
            sum += result;
        }
        return sum;
    }

    public static long add(String cardNumber){
        return sumOfDoubleEvenDigit(cardNumber) + sumOfOddPlaceDigit(cardNumber);
    }


    public static boolean isValidCreditCard(String cardNumber) {
        if (add(cardNumber) % 10 == 0) return true;
        throw new InvalidCreditCardNumberException("Credit card is invalid");
    }
}
