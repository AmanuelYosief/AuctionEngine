/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;


import java.io.IOException;

import java.util.Scanner;

/**
 *
 * @author Amanuel
 */
public class AuctionEngine {
    static concreteBid conn = new concreteBid();
    
        final long value = 0;
    // The person making the bid
//  private final Person bidder;
    // The value of the bid. This is always higher than before
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String filename = "AuctionEngine.txt";
        
// <editor-fold>
        /*
    List<Triplet<String, String, Integer>> Bids = new ArrayList<>();
    // machine indepedent text document database to store all the items and bids on them

    
    System.out.println("Welcome to the Auction Engine");
*/ 
        /*
 
    File file = new File(filename);
            FileWriter fileWriter = new FileWriter(file,true);
            
            */
 // </editor-fold>

    // Create the Scanner
    Scanner scanner = new Scanner(System.in);
    String line;
    long price =0;
    System.out.println("Hit enter to get to get started");
    
        while ((line = scanner.nextLine()) != null) {
            String User = null;
            if (User == null)
            {
            System.out.println("Enter name");
            User= scanner.nextLine();
            }

                        promptMenu();
            here:
            while (true) {
                System.out.print("What would you like to do? ");
                String str = scanner.nextLine();
                switch (str.toUpperCase()) {
                    case "1":
                        System.out.println("Enter the name of the item you want to place a bid for");
                        String item = scanner.nextLine();
                        boolean checkItem = conn.checkItem(item);
                        if (checkItem == true){
                            System.out.println("Enter the price you want to bid");
                            try{
                            price = Long.valueOf(scanner.nextLine());
                            }catch(NumberFormatException e){
                            System.out.println("Expecting numeric value, not: " + line + " ,please try again \r\n" );
                            }
                            conn.PlaceBid(item, price, User);

                        }else {
                        System.out.println("Item doesn't exit");
                        }
                        break here;
                    case "2":                   
                        break here;
                    case "3":
                        conn.readFile(filename);
                        break here;
                    case "4":
                        break here;
                    default:
                        System.err.println("Invalid option, please try again");
                }
            }

        }


    // <editor-fold>
        // Number of pennies
    String message = "";
    
    
    /*
      ArrayList<String> arlist = new ArrayList<String>( );
      arlist.add("JAVA");
      arlist.add("Csharp");
      arlist.add("Python");
      arlist.add("Php");
      arlist.add("Android");
      arlist.add("HTML");
      //Adding "C++" at the sixth position
      arlist.add(5, "C++");
      //displaying elements
      System.out.println(arlist);
      */
    
     // </editor-fold>
}
    
private static void promptMenu( ) {
            System.out.println("\r\n" + "Welcome to the Auction Room. Here are your Options: ");
            System.out.println("[1] to place bids" + "\r\n" + "[2] to display current bids" + "\r\n" + "[3] to display all bids" + "\r\n" + "[4] to leave Auction");
  }


}

