import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;
import java.io.Console;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);   
        String cityname;
        System.out.println("-------------------------- Welcome to Hotel Reservation System --------------------------");
        System.out.print("Enter your city name you want to visit: ");
        cityname = scan.nextLine();

        Hotel h1 = new Hotel(cityname);
        // scan.close();
            h1.start();
        try {
            h1.join();
        } catch (Exception e) {
                System.out.println(e);
        }
        Transaction t1 = new Transaction();
        t1.start();
        try {
                t1.join();
        } catch (Exception e) {
        }
        System.out.println("Your details have been verified");

    L2: while(true){
    System.out.print("Do you want to print the recipt of it(Y/N): ");
        char input = scan.next().charAt(0);
        if(input=='Y'||input=='y'){
            System.out.println("************************RECIPT*************************");
            System.out.println("                Your details are as below           ");
            h1.display(t1);
            System.out.println("*******************************************************");
            break;
        }
        else if(input=='N'||input=='n'){
            System.out.println("OK");
            break;
        }
        else{
            System.out.println("Enter the correct value ");
            continue L2;
        }
    }
        System.out.println("Thank you for coming ");
        scan.close();
    }
    }
    
   




    

class Hotel extends Thread{

    //Variables 
    private boolean chosenOne = true;
    private int select1;
    private int select2;
    private int hotelchosen;
    private int roomchosen;
    private String city;
    private Random random = new Random();
    private Scanner scan = new Scanner(System.in);
    private ArrayList <Room> listofRooms = new ArrayList<Room>();
    private String [] listOfHotels ={"Usman Hotel","Laghari\'s Hotel","Galaxy Hotel","Green Hotel","Taj Hotel"};
    private int [] ChargesPerDay={500,700,300,200,800,150};
    private int ChargePerDay=ChargesPerDay[random.nextInt(5)];

    //Constructors
    public Hotel() {
        this.city = "";
        listofRooms.add(new Room("3nd-Floor, 5S"));
        listofRooms.add(new Room("1st-Floor, 2A"));
        listofRooms.add(new Room("5th-Floor, 1F"));
        listofRooms.add(new Room("8th-Floor, 5C"));
    }
    
    public Hotel(String city) {
        listofRooms.add(new Room("3nd-Floor, 5S"));
        listofRooms.add(new Room("1st-Floor, 2A"));
        listofRooms.add(new Room("5th-Floor, 1F"));
        listofRooms.add(new Room("8th-Floor, 5C"));
        this.city = city;
    }
    
    
    //Methods

    public ArrayList<Room> getListofRooms() {
        return listofRooms;
    }
        
    public void setListofRooms(ArrayList<Room> listofRooms) {
        this.listofRooms = listofRooms;
    }
    
    
    public int getChargePerDay() {
        return ChargePerDay;
    }
    
        
    public void setChargePerDay(int chargePerDay) {
        ChargePerDay = chargePerDay;
    }
    
    
    public String getCity() {
        return city;
    }
    
    
    
    public void setCity(String city) {
        this.city = city;
    }
    
    
    public String[] getListOfHotels() {
        return listOfHotels;
    }
    
    public void setListOfHotels(String[] listOfHotels) {
        this.listOfHotels = listOfHotels;
    }
    
    
    
    @Override
    public String toString() {
        return "Hotel [listOfHotels=" + Arrays.toString(listOfHotels) + ", ChargePerDay=" + ChargePerDay + ", city="
                + city + "]";
    }

        
    public String displayRoom(int roomchosen){
        if(roomchosen>0){
        select2 = roomchosen-1;
        return (listofRooms.get(select2).getRoomNo());
        }
        else{
            return " ";
        }
    }
    
    
    public String SelectHotel(int hotelchosen){

        if(hotelchosen>0){

            select1 = hotelchosen-1;

        return listOfHotels[select1];

        }
        else{
            return " ";
        }
    }

    
    public void displayListofHotels(){
        for(int i =0;i<listOfHotels.length;i++){
            // System.out.print(listOfHotels[i]);
            try {
                Thread.sleep(700);
            } catch (InterruptedException e) {
            
                e.printStackTrace();
            }
            System.out.println((i+1)+". "+listOfHotels[i]);
        }
        
    }

    
    public int getNumberofRooms() {

        return listofRooms.size();

    }
    
    public void displaylistofRooms(){
        for (int i = 0; i < getNumberofRooms(); i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
            }
            System.out.println((i+1)+". "+listofRooms.get(i).getRoomNo());
        }
    }
    
    
    

    
    public void display(Transaction t){
        Transaction first = t;
        System.out.println("Your name: "+first.getname());
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("From City: "+first.getCityname());
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("To City: "+city);
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Hotel Name: "+listOfHotels[select1]);
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Room Number: "+listofRooms.get(select2).getRoomNo());
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Charges per Day: "+ChargePerDay);
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Credit Card "+first.getCreditCard());
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Credit Card CVV "+first.getCVV());
        try{
        Thread.sleep(500);}
        catch(Exception e){

        }
        System.out.println("Credit Card Date of Expiry "+first.getDate_of_Expiry());
        
    }


    @Override
    public void run(){
        
        System.out.println("These are the hotels present in "+getCity());
        do{
            displayListofHotels();
            System.out.println("Which of the above hotel you want to choose: ");
            hotelchosen = scan.nextInt();
            
            if(hotelchosen<=0||hotelchosen>5){
                System.out.println("please select the number mentioned in the list.");
                continue;
            }
            else{

            System.out.print("So");
            try {
                Thread.sleep(1040);
            } catch (InterruptedException e) {
            }
            System.out.println(" , you choose "+ SelectHotel(hotelchosen));
            
            try {
                Thread.sleep(1240);
            } catch (InterruptedException e) {
            }
            System.out.print("And ");
    L1:       while (chosenOne) {
                System.out.println("here number of rooms avaliable in it are: "+getNumberofRooms());
                System.out.println("Which are: ");
                try {
                    Thread.sleep(1240);
                } catch (InterruptedException e) {
                }
            
                displaylistofRooms();
                System.out.println("Which of the above you want to choose: ");
                roomchosen = scan.nextInt();
                if(roomchosen<=0||roomchosen>4){
                    System.out.println("please select number mentioned in above list.");
                    continue L1;
                }
                else{
                    System.out.println("Your room is: "+ displayRoom(roomchosen));
                    try {
                        Thread.sleep(440);
                    } catch (InterruptedException e) {
                    }
                    int ChargePerDay=ChargesPerDay[random.nextInt(5)];
                    System.out.println("It will be Rs."+ChargePerDay+" per day");
                    try {
                        Thread.sleep(540);
                    } catch (InterruptedException e) {
                    }
                
                    System.out.println("Do you wish to continue? (Y/N): ");
                    char option = scan.next().charAt(0);
                    if(option=='Y'||option=='y'){
                        chosenOne=false;
                    }
                    else if(option=='N'||option =='n'){
                        chosenOne = true;
                    }
                    else{
                        System.out.println("choose the correct option: ");
                        chosenOne = true;

                    }
                }
            }
        }
        }while(chosenOne);

    
    }
    
     
    }








 class Transaction extends Thread{
     
        //Variables
         private String Address;
         private String Cityname;
         private long CreditCard;
         private int CVV;
         private String Date_of_Expiry;
         private String Name;
         private Scanner scan =new Scanner(System.in);
         Console cw = System.console();
     
          //Constructors
          
        public Transaction(String name,String address, String cityname, long creditCard, int cVV,
             String date_of_Expiry) {
             Name = name;
             Address = address;
             Cityname = cityname;
             CreditCard = creditCard;
             CVV = cVV;
             Date_of_Expiry = date_of_Expiry;
         }
     
         public Transaction() {
         }
     
         Transaction(long creditCard,int CVV, String date_of_Expiry){
              CreditCard = creditCard;
              this.CVV= CVV;
              Date_of_Expiry = date_of_Expiry;
          }
     
         public String getAddress() {
             return Address;
         }
     
         public void setAddress(String address) {
             Address = address;
         }
     
         public String getCityname() {
             return Cityname;
         }
     
         public void setCityname(String cityname) {
             Cityname = cityname;
         }
     
         public long getCreditCard() {
             return CreditCard;
         }
     
         public void setCreditCard(long creditCard) {
             CreditCard = creditCard;
         }
     
         public int getCVV() {
             return CVV;
         }
     
         public void setCVV(int cVV) {
             CVV = cVV;
         }
     
     
     
         public String getDate_of_Expiry() {
             return Date_of_Expiry;
         }
     
     
     
         public void setDate_of_Expiry(String date_of_Expiry) {
             Date_of_Expiry = date_of_Expiry;
         }
     
         public String getname() {
             return Name;
         }
     
         public void setname(String name) {
             Name = name;
         }
     
     
         /* (non-Javadoc)
          * @see java.lang.Object#toString()
          */
         @Override
         public String toString() {
             return "Transaction [Name="+Name + "\nAddress=" + Address + "\nCityname=" + Cityname
                     + "\nCreditCard=" + CreditCard + "\nCVV=" + CVV + "\nDate_of_Expiry=" + Date_of_Expiry  + "]";
         }
     
     
     
         @Override
         public void run(){
             System.out.println("Good.");
             try {
                 Thread.sleep(1000);
             } catch (Exception e) {
                
             }
             String welcString = "Now For Transaction and Payment of your reservation please provide us following details";
             char[]c =welcString.toCharArray();
             for (int i = 0; i < c.length; i++) {
                 System.out.print(c[i]);
                 try {
                     Thread.sleep(50);
                 } catch (InterruptedException e) {
                   
                 }
         }
         System.out.println();
         System.out.print("Enter your credit card details: ");
             CreditCard = scan.nextLong();
            this.CVV = Integer.parseInt(new String(cw.readPassword("Enter your CVV number: ")));
             System.out.print("Enter your Date of Expiry: ");
             Date_of_Expiry = scan.next();
             System.out.println("Enter your name: ");
             Name = scan.next();
             System.out.println("Enter your City name: ");
             Cityname = scan.next();
         System.out.println("OK");
         try {
             Thread.sleep(1000);
         } catch (Exception e) {
            
         }
         System.out.println("Please let us verify your details");
         try {
             Thread.sleep(1000);
         } catch (Exception e) {
            
         }
         System.out.print("Verifying");
         for (int i = 0; i < 8; i++) {
             System.out.print('.');
             try {
                 Thread.sleep(500);
             } catch (Exception e) {
                
             }
             
         }
         System.out.println();
     }    
     }



