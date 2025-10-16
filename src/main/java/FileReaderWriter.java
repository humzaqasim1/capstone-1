import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    // File reader
    private String fileName = "src/main/resources/transactions.csv";
    private ArrayList<Transactions> transactions = new ArrayList<>();
    // Converting input into list then array list


    public FileReaderWriter() {
        readTransactions();
    }

    public ArrayList<Transactions> getTransactions() {
        return transactions;
    }

    public void readTransactions() {

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
                    System.out.println("Adding Transaction");
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Transaction not found");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
    }

    // File writer
    public void writeTransactions(Transactions transactions) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName, true))) {
            bufferedWriter.write(transactions.toString());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
    }
}
