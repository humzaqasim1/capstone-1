import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Transactions> transactions = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);
    public static String fileName = "src/main/resources/transactions.csv";

    public static void main(String[] args) {
        readTransactions();
        displayHomeScreen();

    }

    public static void displayHomeScreen() {
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
                    displayLedgerScreen();
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
        System.out.println("Add New Deposit\n");
        Transactions transactions = getTransactionsInfo(true);
        Main.transactions.add(transactions);
        writeTransactions(transactions);
        System.out.println("Adding Deposit...");


    }

    public static void makePayment() {
        System.out.println("Make Payment\n");
        Transactions transactions = getTransactionsInfo(false);
        Main.transactions.add(transactions);
        writeTransactions(transactions);
        System.out.println("Making Payment...");
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
                    displayAllEntries();
                    System.out.println("Displaying All Entries: ");
                    break;
                case "D":
                    System.out.println("Displaying Only Deposits: ");
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

    private static void displayAllEntries() {
        for (Transactions t : transactions) {
            System.out.println(t);
        }
    }

    public static void readTransactions() {
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
                transactions.add(transaction);

            }
        } catch (FileNotFoundException e) {
            System.out.println("Transaction file not found: " + fileName);
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }
    public static void writeTransactions(Transactions transactions) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(transactions.toString());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }

}
