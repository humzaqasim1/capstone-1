import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {
    ArrayList<Transactions> entries = new ArrayList<>();

    // Creating home screen options
    public static void display() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nWelcome to the Home Screen\n");
            System.out.println("Choose an Option: ");
            System.out.println("D: Add Deposit");
            System.out.println("P: Make Payment");
            System.out.println("L: Display Ledger");
            System.out.println("X: Exit Application");
            String userChoice = scanner.nextLine().trim().toUpperCase();
            switch (userChoice) {
                case "D":
                    addDeposit();
                    break;
                case "P":
                    makePayment();
                    break;
                case "L":
                    break;
                case "X":
                    System.out.println("Exiting Application");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    // Making add deposit option
    public static void addDeposit() {
            FileReaderWriter fileReaderWriter = new FileReaderWriter();
            System.out.println("Add New Deposit\n");
            System.out.println("Enter Deposit Details: ");
            //public Transactions(LocalDate date, LocalTime time, String details, String vendor, Double amount)
            Transactions transactions = getTransactionsInfo(true);
            fileReaderWriter.writeTransactions(transactions);

    }

    public static void makePayment() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        System.out.println("Make Payment\n");
        System.out.println("Enter Payment Details: ");
        Transactions transactions = getTransactionsInfo(true);
        fileReaderWriter.writeTransactions(transactions);
    }

    public static Transactions getTransactionsInfo(boolean isDeposit) {
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter Details: ");
            String details = scanner.nextLine();

            System.out.println("Enter Vendor: ");
            String vendor = scanner.nextLine();

            System.out.println("Enter Amount: ");
            Double amount = Double.parseDouble(scanner.nextLine());

            if (!isDeposit) {
                amount = -Math.abs(amount);
            }
            else {
                amount = Math.abs(amount);
            }
            LocalDate date = LocalDate.now();
            LocalTime time = LocalTime.now();
            return new Transactions(date, time, details, vendor, amount);

        } catch (NumberFormatException e) {
            System.out.println("Error" + e.getMessage());
            return null;
        }
    }

}

