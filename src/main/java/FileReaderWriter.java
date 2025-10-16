import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    // File reader
    private String fileName = "src/main/resources/transactions.csv";

    public FileReaderWriter() {
    }


    public ArrayList<Transactions> readTransactions() {
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
