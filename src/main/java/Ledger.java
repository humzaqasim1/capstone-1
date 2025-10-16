import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ledger {
    private List<Transactions> transactions;
    private Scanner scanner = new Scanner(System.in);
    private FileReaderWriter fileReaderWriter;
    public Ledger(List<Transactions> transactions) {
        this.transactions = new ArrayList<>(transactions);
//        this.fileReaderWriter = new FileReaderWriter();
    }

    public Ledger() {
    }

    public void setTransactions(List<Transactions> transactions) {
        this.transactions = transactions;
    }

    public void displayLedgerScreen() {
        this.transactions = fileReaderWriter.getTransactions();
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

    public void sortLedger(String choice) {
        boolean match = false;
        for (Transactions transaction : this.transactions) {
            if (choice == "A"){
                match = true;
            }
            if (match){
                System.out.println(transaction.toString());
            }

        }

    }
}
