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

    static concreteBid auctionSystem = new concreteBid();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String username = null;
                int price = 0;
        // Create the Scanner
        Scanner scanner = new Scanner(System.in);

        System.out.println("------------------------");
        System.out.println("|Welcome to the Auction|");
        System.out.println("------------------------");

        // Check username isn't null or empty
        while (username == null || username.trim().equals("")){
            System.out.println("Provide username:");
            username = scanner.nextLine().trim();
        }
        
        
        String SystemState = "0";
        while (SystemState != null) {
            while (true) {
                promptMenu();
                System.out.print("What would you like to do? ");
                SystemState = scanner.nextLine();
                here:
                switch (SystemState.trim()) {
                    case "1":
                           // User wants to place a bid
                            auctionSystem.displayItem();
                            
                            System.out.println("Enter the name of the item you want to place a bid for");
                            String item = scanner.nextLine().trim();
                            
                            // Check if the item exists
                            boolean checkItem = auctionSystem.checkItem(item);
                            if (checkItem == true) {
                                System.out.println("Enter the price you want to bid");
                                try {
                                    price = Integer.parseInt(scanner.nextLine());
                                    if (price % 1 == 0) {
                                        // Price is a whole number
                                // Get's the max bid on the item
                                int maxValue = auctionSystem.getMaxValue(item);
                                if (price < maxValue) {
                                    System.out.println("Bid must be higher than the current highest bid of "  + maxValue);
                                } else {
                                    // New Bid is higher than previous max bid
                                    auctionSystem.placeBid(item, price, username);
                                }
                                    } else {
                                        System.out.println("Not a whole number " + price + ", try again \r\n");
                                        break here;
                                    }
                                } catch (NumberFormatException e) {
                                    System.out.println("Expecting a whole number value, not: " + price + ", try again \r\n");
                                    break here;
                                }
  
                            } else {
                                // Check item failed, item doesn't exist in our database
                                System.out.println(item + " is not listed for bid. Try again");
                                break here;
                            }
                            // Display main menu and breaks back into the loop
                        SystemState = "Main Menu";
                        break here;
                    case "2":
                        // User want's to see current winng bid prices for an item
                        // Display all the items
                        auctionSystem.displayItem();
                        // Get the current winning bid for an iem
                        System.out.println("Enter item name ");
                        item = scanner.nextLine().trim();
                        // Check if the item exists
                        checkItem = auctionSystem.checkItem(item);
                        if (checkItem == true) {
                            String Price = auctionSystem.getCurrentBid(item);
                            System.out.println("Current bid price: £" + Price);
                        } else {
                            System.out.println(item + " is not listed for bid. Try again");
                        }
                        SystemState = "Main Menu";
                        break here;
                    case "3":
                        // Get all the bids for an item
                        auctionSystem.displayAllItems();
                        SystemState = "Main Menu";
                        break here;
                    case "4":
                        auctionSystem.displayUsersBids(username);
                        // Get all the items on which a user has a bid
                        break here;
                    case "5":
                        System.exit(0);
                    default:
                        System.out.println("Incorrect input value; try again");
                        SystemState = "Main Menu";
                }
            }
        }
    }
    private static void promptMenu() {
        System.out.println("\r\n" + "Auction Options");
        System.out.println("[1] to place bids" + "\r\n" + "[2] to display current winning bids" + "\r\n" + "[3] to display all bids" + "\r\n" + "[4] to display all your current bids" + "\r\n" + "[5] to leave Auction");
    }
}