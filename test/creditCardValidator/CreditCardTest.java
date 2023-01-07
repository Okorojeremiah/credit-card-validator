package creditCardValidator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CreditCardTest {

    @Test
    public void testThatCreditLengthIsValid(){
        boolean isValidLength = CreditCard.isValidLength("434576577876543");
        assertTrue(isValidLength);
    }

    @Test
    public void InvalidCreditCardLengthExceptionTest(){
        assertThrows(CreditCardLengthException.class, ()-> CreditCard.isValidLength("45676785334556784"));
    }

    @Test
    @DisplayName("Credit card must start with 4 for Visa card, 5 for Master card, 6 for Discover card and 37 fro American Express card")
    public void creditCardNumberIsValidNumberTest(){
        boolean isValidNumber = CreditCard.isValidNumber("43478989089089");
        assertTrue(isValidNumber);

        boolean isValidNumber2 = CreditCard.isValidNumber("53478989089089");
        assertTrue(isValidNumber2);

        boolean isValidNumber3 = CreditCard.isValidNumber("63478989089089");
        assertTrue(isValidNumber3);

        boolean isValidNumber4 = CreditCard.isValidNumber("37478989089089");
        assertTrue(isValidNumber4);
    }

    @Test
    public void InvalidCreditCardNumberTest(){
        assertThrows(InvalidCreditCardNumberException.class, ()-> CreditCard.isValidNumber("76545678987654"));
    }

    @Test
    @DisplayName("Doubles every second digits from right to left, if doubling of a digit results in two digit number, adds up the two digits to get a single digit")
    public void sumOfDoubleEvenDigitTest(){
        String cardNumber = "4388576018402626";
        assertEquals(37, CreditCard.sumOfDoubleEvenDigit(cardNumber));
    }

    @Test
    public void sumOfOddPlaceDigitTest(){
        String cardNumber = "4388576018402626";
        assertEquals(38, CreditCard.sumOfOddPlaceDigit(cardNumber));
    }

    @Test
    @DisplayName("Adds the sum of double even place digit and the sum of odd place digit")
    public void sumOfOddPlaceDigitAndDoubleEvenPlaceDigitTest(){
        String cardNumber = "4388576018402626";
        assertEquals(75, CreditCard.add(cardNumber));
    }

    @Test
    public void creditCardValidityTest(){
        String cardNumber = "5399412017493730";
        boolean isValidCreditCard = CreditCard.isValidCreditCard(cardNumber);
        assertTrue(isValidCreditCard);
    }


}
