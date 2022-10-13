//Hotel class

import java.util.ArrayList;
import java.util.Arrays;
import java.lang.String;
import java.lang.Thread;
import java.util.Random;
import java.util.Scanner;


public class Hotel extends Thread

 {
        //Variables 
    ArrayList <Room> listofRooms = new ArrayList<Room>();
    Random random = new Random();
    private int [] ChargesPerDay={500,700,300,200,800,150};
    private String [] listOfHotels ={"Usman Hotel","Laghari\'s Hotel","Galaxy Hotel","Green Hotel","Taj Hotel"};
    private int ChargePerDay=ChargesPerDay[random.nextInt(5)];
    private String city;
    private String Transaction[]=new String[3];
    private int select1;
    private int select2;
    private boolean chosenOne = false;
    private String ask;
    private int hotelchosen;
    private int roomchosen;
    private Room a=new Room();
   
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

    
    public void display(){
        Transaction first = new Transaction();
        System.out.println("Your name: "+first.getName());
        System.out.println("Your Father's name: "+first.getFathers_name());
        System.out.println("From City: "+first.getCityname());
        System.out.println("To City: "+city);
        System.out.println("Hotel Name: "+listOfHotels[select1]);
        System.out.println("Room Number: "+listofRooms.get(select2).getRoomNo());
        System.out.println("Charges per Day: "+ChargePerDay);
        System.out.println("Credit Card "+Transaction[0]);
        System.out.println("Credit Card CVV "+Transaction[1]);
        System.out.println("Credit Card Date of Expiry "+Transaction[2]);
        for(Room a:listofRooms){
            System.out.println(a);
           }
    }

    @Override
    public void run(){
        
        Scanner scan = new Scanner(System.in);
        System.out.println("These are the hotels present in "+getCity());
        do{
            displayListofHotels();
            System.out.println("Which of the above hotel you want to choose: ");
            hotelchosen = scan.nextInt();
            System.out.print("So");
            try {
                Thread.sleep(1240);
            } catch (InterruptedException e) {
            }
            System.out.println(" , you choose "+ SelectHotel(hotelchosen));
            
            try {
                Thread.sleep(1240);
            } catch (InterruptedException e) {
            }
            System.out.println("And here, number of rooms avaliable in it are: "+getNumberofRooms());
            try {
                Thread.sleep(1240);
            } catch (InterruptedException e) {
            }
            System.out.println("Which are: ");
            displaylistofRooms();
            System.out.println("Which of the above you want to choose: ");
            roomchosen = scan.nextInt();
            System.out.println("Your room is: "+ displayRoom(roomchosen));
            System.out.println("It will be Rs."+getChargePerDay()+" per day");
            System.out.print("Enter your Credit Card detials seperated by comma(Credit-Card Number,Date of Expiry, CVV): ");
           System.out.print(" ");
            
           chosenOne = true;
            while(scan.hasNextLine()){
                ask = scan.next();
                String CVV = ask;
                if (ask.equals(CVV)) {
                        break;
                }

        }
        Transaction = ask.split(",");
        chosenOne = false;
            // scan.close();
            System.out.print("Verifying");
            for (int i = 0; i < 8; i++) {
                System.out.print('.');
                try {
                    Thread.sleep(850);
                } catch (InterruptedException e) {
                }   
            }
            System.out.println(" ");
            System.out.println("Your data has been verified.");
            System.out.print("And ");
            try {
                Thread.sleep(900);
            } catch (InterruptedException e) {
            }   
            System.out.println("here are your details");
            display();

        }while(chosenOne);
    
            scan.close();
    }

}
