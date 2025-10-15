import java.util.List;
import java.util.Scanner;

public class Ledger {
    private List<Transactions> transactions;
    private Scanner scanner;

    public Ledger(List <Transactions> transactions){
        this.transactions = transactions;
        this.scanner = new Scanner(System.in);
    }
    public void displayLedgerScreen(){
        System.out.println("Choose an Option: ");
        System.out.println("A: All - Display All Entries");
        System.out.println("D: Deposits - Display Only Deposits");
        System.out.println("P: Payments - Display Only Payments");
        System.out.println("R: Report Screen");
        System.out.println("H: Home - Return to Home Screen");

        String choice = scanner.nextLine().trim().toUpperCase();
        switch (choice){
            case "A":
                break;
            case "D":
                break;
            case "P":
                break;
            case "R":
                break;
            case "H":
                return;
            default:
                System.out.println("Invalid Choice");;
        }

    }
}
//private void displayAllEntries(){
//    System.out.println("All Entries:\n");

//private
