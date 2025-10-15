import java.time.LocalDate;
import java.time.LocalTime;
public class Transactions {
    // Declaring variables to be used
    LocalDate date;
    LocalTime time;
    private String details;
    private String vendor;
    private Double amount;

    public Transactions(LocalDate date, LocalTime time, String details, String vendor, Double amount){
        this.date = date;
        this.time = time;
        this.details = details;
        this.vendor = vendor;
        this.amount = amount;
    }
    public LocalDate getDate() {return date;}
    public void setDate(LocalDate date) {this.date = date;}
    public LocalTime getTime() {return time;}
    public void setTime(LocalTime time) {this.time = time;}
    public String getDetails() {return details;}
    public void setDetails(String details) {this.details = details;}
    public String getVendor() {return vendor;}
    public void setVendor(String vendor) {this.vendor = vendor;}
    public Double getAmount() {return amount;}
    public void setAmount(Double amount) {this.amount = amount;}

    public Boolean isDeposit(){
        return amount > 0;
    }
    public boolean isPayment(){
        return amount < 0;
    }
    // formatting output
    public String toString(){
        return String.format("%s | %s | %s | %s | %.2f", date, time, details, vendor, amount);
    }
    // array formatting
    public static Transactions fromString(String line){
        String [] parts = line.split("\\|");
        LocalDate date = LocalDate.parse(parts[0]);
        LocalTime time = LocalTime.parse(parts[1]);
        String details = parts[2];
        String vendor = parts[3];
        Double amount = Double.parseDouble(parts[4]);
        return new Transactions(date, time, details, vendor, amount);
    }

}
