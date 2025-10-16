import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    static ArrayList<Transactions> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        FileReaderWriter readerWriter = new FileReaderWriter();
        transactions = readerWriter.readTransactions();
        HomeScreen homeScreen = new HomeScreen();
        displayHomeScreen();

    }

    public static void displayHomeScreen() {
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

    public static void addDeposit() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        System.out.println("Add New Deposit\n");
        System.out.println("Enter Deposit Details: ");
        //public Transactions(LocalDate date, LocalTime time, String details, String vendor, Double amount)
        Transactions transactions = getTransactionsInfo(true);
        Main.transactions.add(transactions);
        fileReaderWriter.writeTransactions(transactions);
        System.out.println("Adding Deposit...");
        transactions.add(transactions);

    }

    public static void makePayment() {
        FileReaderWriter fileReaderWriter = new FileReaderWriter();
        System.out.println("Make Payment\n");
        Transactions transactions = getTransactionsInfo(false);
        Main.transactions.add(transactions);
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
            } else {
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
    public static void displayLedgerScreen() {
//        this.transactions = fileReaderWriter.getTransactions();
        boolean running = true;
        while (running) {

            System.out.println("Choose an Option: ");
            System.out.println("A: All - Display All Entries");
            System.out.println("D: Deposits - Display Only Deposits");
            System.out.println("P: Payments - Display Only Payments");
            System.out.println("R: Report Screen");
            System.out.println("H: Home - Return to Home Screen");

            String choice = scanner.nextLine().trim().toUpperCase();
            switch (choice) {
                case "A":
                    System.out.println("Displaying All Entries: ");
                    sortLedger(choice);
                    break;
                case "D":
                    System.out.println("Displaying Only Deposits: ");
                    sortLedger(choice);
                    break;
                case "P":
                    System.out.println("Displaying Only Payments: ");
                    break;
                case "R":
                    System.out.println("Displaying Report Screen: ");
                    break;
                case "H":
                    System.out.println("Returning to Home Screen");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }

    }
    public static ArrayList<Transactions> readTransactions() {
        ArrayList<Transactions> transactions = new ArrayList<Transactions>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Making sure string is not empty
            while ((line = bufferedReader.readLine()) != null) {
                String[] parts = line.split("\\|");
                LocalDate date = LocalDate.parse(parts[0]);
                LocalTime time = LocalTime.parse(parts[1]);
                String details = parts[2];
                String vendor = parts[3];
                Double amount = Double.parseDouble(parts[4]);
                Transactions transaction = new Transactions(date, time, details, vendor, amount);
                if (!line.trim().isEmpty()) {
                    transactions.add(transaction);
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Transaction file not found: " + fileName );
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return transactions;
    }
}

