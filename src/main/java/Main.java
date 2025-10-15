import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    Scanner scanner = new Scanner(System.in);
//    FileReader fileReader = new FileReader("src/main/resources/transactions.csv");
//    BufferedReader bufferedReader = new BufferedReader(fileReader);
    public static void main(String[] args) {
        homeScreen();


    }
    private static void homeScreen() {
        System.out.println("\nWelcome to the Home Screen\n");
        System.out.println("Choose an Option: ");
        System.out.println("A: Add Deposit");
        System.out.println("B: Make Payment");
        System.out.println("C: Display Ledger");
        System.out.println("D: Exit Application");
    }
}
