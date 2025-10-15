import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileReaderWriter {
    // File reader
    private static String fileName = "src/main/resources/transactions.csv";

    // Converting input into list then array list

    public static List<Transactions> readTransactions(){
        List<Transactions> transactions = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))){
            String line;
            // Making sure string is not empty
            while((line = bufferedReader.readLine()) != null){
                if (!line.trim().isEmpty()){
                    transactions.add(Transactions.fromString(line));
                }

            }
        } catch (FileNotFoundException e) {
            System.out.println("Transaction not found");
        } catch (IOException e) {
            System.out.println("Error" + e.getMessage());
        }
        return transactions;
    }
    public static void writeTransactions (List<Transactions> transactions){
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(fileName))){
            bufferedWriter.write(transactions.toString());
            bufferedWriter.newLine();
        } catch (IOException ex) {
            System.out.println("Error" + ex.getMessage());
        }
        }
    }
