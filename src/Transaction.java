//import java.util.Scanner;
//import java.lang.Thread;


public class Transaction {
     
   
    /**
     *
     */
    private String Fathers_name;
    /**
     *
     */
    private String Address;
    /**
     *
     */
    private String Cityname;
    /**
     *
     */
    private long CreditCard;
    /**
     *
     */
    private int CVV;
    /**
     *
     */
    private String Date_of_Expiry;
    /**
     *
     */
    private String Name;
    
     //Scanner
    // Scanner scan ;

     //Constructors
     
     /**
     * Constructor
     * Transcation
     * @param fathers_name
     * @param address
     * @param cityname
     * @param creditCard
     * @param cVV
     * @param date_of_Expiry
     * @param name
     */
    public Transaction(String fathers_name, String address, String cityname, long creditCard, int cVV,
            String date_of_Expiry, String name) {
        Name = name;
        Fathers_name = fathers_name;
        Address = address;
        Cityname = cityname;
        CreditCard = creditCard;
        CVV = cVV;
        Date_of_Expiry = date_of_Expiry;
    }

    /**
     * 
     */
    public Transaction() {
    }

    /**
     * @param creditCard
     * @param CVV
     * @param date_of_Expiry
     */
    Transaction(long creditCard,int CVV, String date_of_Expiry){
         CreditCard = creditCard;
         this.CVV= CVV;
         Date_of_Expiry = date_of_Expiry;
     }

    /**
     * @return
     */
    public String getFathers_name() {
        return Fathers_name;
    }

    /**
     * @param fathers_name
     */
    public void setFathers_name(String fathers_name) {
        Fathers_name = fathers_name;
    }

    /**
     * @return
     */
    public String getAddress() {
        return Address;
    }

    /**
     * @param address
     */
    public void setAddress(String address) {
        Address = address;
    }

    /**
     * @return
     */
    public String getCityname() {
        return Cityname;
    }

    /**
     * @param cityname
     */
    public void setCityname(String cityname) {
        Cityname = cityname;
    }

    /**
     * @return
     */
    public long getCreditCard() {
        return CreditCard;
    }

    /**
     * @param creditCard
     */
    public void setCreditCard(long creditCard) {
        CreditCard = creditCard;
    }

    /**
     * @return
     */
    public int getCVV() {
        return CVV;
    }

    /**
     * @param cVV
     */
    public void setCVV(int cVV) {
        CVV = cVV;
    }

    /**
     * @return
     */
    public String getDate_of_Expiry() {
        return Date_of_Expiry;
    }

    /**
     * @param date_of_Expiry
     */
    public void setDate_of_Expiry(String date_of_Expiry) {
        Date_of_Expiry = date_of_Expiry;
    }

    /**
     * @return
     */
    public String getName() {
        return Name;
    }

    /**
     * @param name
     */
    public void setName(String name) {
        Name = name;
    }


    /* (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "Transaction [Name="+Name+"\nFather's name=" + Fathers_name + "\nAddress=" + Address + "\nCityname=" + Cityname
                + "\nCreditCard=" + CreditCard + "\nCVV=" + CVV + "\nDate_of_Expiry=" + Date_of_Expiry  + "]";
    }
    
}
