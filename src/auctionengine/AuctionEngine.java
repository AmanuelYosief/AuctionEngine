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
        String filename = "AuctionEngine.txt";
        String username = null;
        // Create the Scanner
        Scanner scanner = new Scanner(System.in);
        long price = 0;
        System.out.println("------------------------");
        System.out.println("|Welcome to the Auction|");
        System.out.println("------------------------");

        while (username == null || username.trim().equals("")){
            System.out.println("Provide username:");
            username = scanner.nextLine().trim();
        }

        //System.out.println("enter to get to get started");
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
                            auctionSystem.DisplayItems();
                            System.out.println("Enter the name of the item you want to place a bid for");
                            String item = scanner.nextLine().trim();
                            // Check if the item exists
                            boolean checkItem = auctionSystem.checkItem(item);
                            if (checkItem == true) {
                                System.out.println("Enter the price you want to bid");
                                try {
                                    price = Long.valueOf(scanner.nextLine());
                                } catch (NumberFormatException e) {
                                    System.out.println("Expecting numeric value, not: " + price + ", try again \r\n");
                                    break here;
                                }
                                int maxValue = auctionSystem.getMaxValue(item);
                                if (price < maxValue) {
                                    System.out.println("New bid must be higher");
                                } else {
                                    // New Bid is higher than previous max bid
                                    auctionSystem.PlaceBid(item, price, username);
                                }
                            } else {
                                System.out.println(item + " is not listed for bid. Try again");
                                break here;
                            }
                        SystemState = "Main Menu";
                        break here;
                    case "2":
                        auctionSystem.displayItem();
                        // Get the current winning bid for an iem
                        System.out.println("Enter item name ");
                        item = scanner.nextLine().trim();
                        // Check if the item exists
                        checkItem = auctionSystem.checkItem(item);
                        if (checkItem == true) {
                            String Price = auctionSystem.getCurrentBid(item);
                            System.out.println("Current bid price: " + Price);
                        } else {
                            System.out.println(item + " is not listed for bid. Try again");
                        }
                        SystemState = "Main Menu";
                        break here;
                    case "3":
                        // Get all the bids for an item
                        auctionSystem.displayItem();
                        // Get the current winning bid for an iem
                        System.out.println("Enter item name ");
                        item = scanner.nextLine().trim();
                        // Check if the item exists
                        checkItem = auctionSystem.checkItem(item);
                        if (checkItem == true) {
                            //   System.out.println(" Bid item is listed");
                            //getCurrentBid();
                            String Price = auctionSystem.getCurrentBid(item);
                            int maxValue = 0;
                        } else {
                            System.out.println(item + " is not listed for bid. Try again");
                        }
                        SystemState = "Main Menu";
                        break here;
                    case "4":
                        auctionSystem.displayUsersBids(username);
                        // Get all the items on which a user has a bid
                        break here;
                    case "5":
                        System.exit(0);
                    default:
                        System.out.println("Invalid input try again");
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