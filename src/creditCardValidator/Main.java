package creditCardValidator;

import java.util.Scanner;

import static java.lang.System.exit;

public class Main {
    public static void main(String[] args) {
        startApp();
    }

    public static void startApp() {
        String mainMenu = """
                CREDIT CARD VALIDITY CHECK
                1. Check credit card
                2. End
                """;
        String userInput = input(mainMenu);
        switch (userInput){
            case "1" -> validityCheck();
            case "2" -> exit(2);
        }
    }

    private static void display(String prompt){
        System.out.println(prompt);
    }
    private static String input(String prompt) {
        display(prompt);
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    private static void validityCheck() {
        String cardNumber = input("Enter your credit card number: ");
        try {
            if (CreditCard.isValidCreditCard(cardNumber)) System.out.println("Valid");
        }catch (InvalidCreditCardNumberException | CreditCardLengthException exception){
            System.out.println(exception.getMessage());
        }
        startApp();
    }
}
