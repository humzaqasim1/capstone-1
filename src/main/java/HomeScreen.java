import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class HomeScreen {
    FileReaderWriter fileReaderWriter = new FileReaderWriter();
    ArrayList<Transactions> entries = new ArrayList<>();
    Scanner scanner = new Scanner(System.in);
    Ledger ledger = new Ledger();
    // Creating home screen options

    public HomeScreen() {
    }

    public ArrayList<Transactions> getEntries() {
        return entries;
    }

    public void display() {
//        this.entries = fileReaderWriter.getTransactions();
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
                    ledger.displayLedgerScreen();
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
    public void addDeposit() {
            FileReaderWriter fileReaderWriter = new FileReaderWriter();
            System.out.println("Add New Deposit\n");
            System.out.println("Enter Deposit Details: ");
            //public Transactions(LocalDate date, LocalTime time, String details, String vendor, Double amount)
            Transactions transactions = getTransactionsInfo(true);
            fileReaderWriter.writeTransactions(transactions);
            System.out.println("Adding Deposit...");
            entries.add(transactions);

    }

    public void makePayment() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        System.out.println("Make Payment\n");
        Transactions transactions = getTransactionsInfo(false);
        fileReaderWriter.writeTransactions(transactions);
        System.out.println("Making Payment...");
        entries.add(transactions);
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

