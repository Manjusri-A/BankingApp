import java.util.HashMap;
import java.util.Scanner;

public class BankingAppClass {
    private static HashMap<String, BankingSystem> accounts = new HashMap<>();
    private static HashMap<String, CardSystemclass> cards = new HashMap<>();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Our Banking App");

        while (true) {
            showMainMenu();
            int option = scan.nextInt();
            scan.nextLine(); 

            switch (option) {
                case 1:
                    createNewAccount();
                    break;
                case 2:
                    performBankingOperations();
                    break;
                case 3:
                    manageCardDetails();
                    break;
                case 4:
                    System.out.println("-------------Thank you for using the Banking App------------");
                    return;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private static void showMainMenu() {
        System.out.println("1. Create New Account");
        System.out.println("2. Banking Operations");
        System.out.println("3. Card Details");
        System.out.println("4. Exit");
        System.out.print("Enter your choice: ");
    }

    private static void createNewAccount() {
        System.out.print("Enter Account Holder Name: ");
        String name = scan.nextLine();
        System.out.print("Enter Mobile Number (Account Number): ");
        String accountNumber = scan.nextLine();
        accounts.put(accountNumber, new BankingSystem(accountNumber, name));
        System.out.println("Account created successfully for " + name);
    }

    private static void performBankingOperations() {
        System.out.print("Enter Account Number: ");
        String accountNumber = scan.nextLine();

        if (!accounts.containsKey(accountNumber)) {
            System.out.println("Account not found!");
            return;
        }

        BankingSystem account = accounts.get(accountNumber);
        System.out.println("\nBanking Operations:");
        System.out.println("1. Check Balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.print("Enter your choice: ");
        int bankingOption = scan.nextInt();

        switch (bankingOption) {
            case 1:
                System.out.println("Your balance is: " + account.getBalance());
                break;
            case 2:
                System.out.print("Enter amount to withdraw: ");
                double withdrawAmount = scan.nextDouble();
                account.withdraw(withdrawAmount);
                break;
            case 3:
                System.out.print("Enter amount to deposit: ");
                double depositAmount = scan.nextDouble();
                account.deposit(depositAmount);
                break;
            default:
                System.out.println("Invalid option.");
        }
    }

    private static void manageCardDetails() {
        System.out.print("Enter Card Number: ");
        String cardNumber = scan.nextLine();

        if (!cards.containsKey(cardNumber)) {
            System.out.print("Card not found! Create a new card (y/n)? ");
            char createCard = scan.next().toLowerCase().charAt(0);
            scan.nextLine(); 

            if (createCard == 'y') {
                System.out.print("Enter PIN Number: ");
                String pinNumber = scan.nextLine();
                System.out.print("Enter Expiry Year: ");
                String expiryYear = scan.nextLine();
                cards.put(cardNumber, new CardSystemclass(cardNumber, pinNumber, expiryYear));
                System.out.println("Card created successfully.");
            }
        } else {
            CardSystemclass card = cards.get(cardNumber);
            System.out.println("\nCard Operations:");
            System.out.println("1. View PIN Number");
            System.out.println("2. View Expiry Year");
            System.out.print("Enter your choice: ");
            int cardOption = scan.nextInt();

            if (cardOption == 1) {
                System.out.println("PIN Number: " + card.getPinNumber());
            } else if (cardOption == 2) {
                System.out.println("Expiry Year: " + card.getExpiryYear());
            } else {
                System.out.println("Invalid option.");
            }
        }
    }
}

