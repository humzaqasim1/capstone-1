import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);

    //FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
    BufferedReader bufferedReader = new BufferedReader(fileReader);
    public static void main(String[] args) {


    }

    public static void inputSwitch() {
        while (true) {

            homeScreen();
            String userChoice = scanner.nextLine().trim().toUpperCase();
            switch (userChoice) {
                case "A":
                    break;
                case "B":
                    break;
                case "C":
                    break;
                case "D":
                    System.out.println("Exiting Application");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }

    private static void homeScreen() {
        System.out.println("\nWelcome to the Home Screen\n");
        System.out.println("Choose an Option: ");
        System.out.println("A: Add Deposit");
        System.out.println("B: Make Payment");
        System.out.println("C: Display Ledger");
        System.out.println("D: Exit Application");
    }

    private static void addDeposit() {
        try {
            System.out.println("Add New Deposit");
            System.out.println("Enter Deposit Details: ");
            String details = scanner.nextLine();

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
