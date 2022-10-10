import java.util.*;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);   
        String cityname;

        System.out.println("-------------------------- Welcome to Hotel Reservation System --------------------------");
        System.out.print("Enter your city name you want to visit: ");
        cityname = scan.nextLine();

    //     Hotel h1 = new Hotel(cityname);
    //     scan.close();
    //     h1.start();
    //    try {
        
    //        h1.join();
    //    } catch (Exception e) {
    //     // TODO: handle exception
    //    }
        String ask = scan.nextLine();
        String [] Tra = ask.split(",");
        for (int i = 0; i < Tra.length; i++) {
            System.out.println(Tra[i]);
        }
        System.out.println("Thank you for coming ");
        }
    }

