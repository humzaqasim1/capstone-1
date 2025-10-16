import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class Main {
    public static ArrayList<Transactions> transactions = new ArrayList<>();

    public static void main(String[] args) {
        FileReaderWriter readerWriter = new FileReaderWriter();
        transactions = readerWriter.readTransactions();
        HomeScreen homeScreen = new HomeScreen();
        homeScreen.display();

    }
}
