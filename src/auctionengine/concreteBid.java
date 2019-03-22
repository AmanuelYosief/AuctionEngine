/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Amanuel
 */
public class concreteBid implements interfaceBid {

    // Local pesistant database
    File fileName = new File("AuctionEngine.txt");

    public concreteBid() {
    }

    // Records a User's bid

    @Override
    public void placeBid(String item, int price, String bidder) {
        try (Writer writer = new BufferedWriter(new FileWriter(fileName, true))) {
            String content = item + "\t" + price + "\t" + bidder;
            writer.write(content + "\r\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Get the current winning bid for an item
    @Override
    public String getCurrentBid(String item) {
        String itemPrice;
        String tmp[] = null;
        try {
            Scanner file = new Scanner(fileName);
            while (file.hasNextLine()) {
                final String lineFromFile = file.nextLine();
                if (lineFromFile.contains(item)) {
                    tmp = lineFromFile.split("\t");
                    itemPrice = tmp[1];
                    return "£" + itemPrice;
                }
            }
            return null;
        } catch (FileNotFoundException ex) {
            Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
// Check the item exists so that a bid can be placed
    @Override
    public boolean checkItem(String item) {
        // Ensure the item entered isn't null or has numeric value inside
        if (item.trim() == null || item.trim().equals("") || stringContainsNumber(item) == true) {
            return false;
        } else {

            boolean exists = false;
            String tmp[] = null;
            Scanner filez = null;
            try {
                filez = new Scanner(fileName);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (filez.hasNextLine()) {
                final String lineFromFile = filez.nextLine();
                // Checks that the line contains the item, return True if item exists
                if (lineFromFile.contains(item)) {
                    tmp = lineFromFile.split("\t");
                    exists = true;
                }
                if (exists = true) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return false;
    }
    
// Ensure inputs don't contain integers
    @Override
    public boolean stringContainsNumber(String s) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(s);
        return m.find();
    }
    
// Get maximum bid price set on an item
    @Override
    public int getMaxValue(String item) throws FileNotFoundException {

        // ArrayList is used to store all the item's prices
        List<Integer> list = new ArrayList<Integer>();
        String tmp[] = null;
        Scanner filez = new Scanner(fileName);
        while (filez.hasNextLine()) {
            final String lineFromFile = filez.nextLine();
            if (lineFromFile.contains(item)) {
                tmp = lineFromFile.split("\t");
                // Adds prices to ArrayList
                int price = Integer.parseInt(tmp[1]);
                list.add(price);
            }
        }
        // Collection.max(List) returns the maximum value from our ArrayList
        return Collections.max(list);
    }

    // Display all the bidders for all items
    @Override
    public void displayAllItems() {
        // System format is used to change the output and draw a table in CLI
        try {
            BufferedReader br = new BufferedReader(new FileReader("AuctionEngine.txt"));
            String line = null;
            System.out.println("\r\n" + "     ---Auction Items----     ");
            String format = "%1$-16s%2$-16s%3$-1s\n";
            System.out.format(format, "Item", "Bid Price", "Bidder");
            while ((line = br.readLine()) != null) {
                String tmp[] = line.split("\t");
                String item = tmp[0];
                int bidPrice = Integer.parseInt(tmp[1]);
                String name = tmp[2];
                format = "|%1$-15s|%2$-15s|%3$-15s|\n";
                System.out.format(format, item, "£" + bidPrice, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
// Display all the items available to be bidded on
    @Override
    public void displayItem() {
        // DisplayItem presents the user with all the items in the Auction
        // Retrieve Items
        // Saves items into an List, this is converted into a Set to remove duplicates
        // Once duplicates are removed, user is presented with the result.
        String tmp[] = null;
        List<String> list = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("AuctionEngine.txt"));
            String line = null;
            System.out.println("     ---Auction Items Available----     ");
            while ((line = br.readLine()) != null) {
                tmp = line.split("\t");
                String item = tmp[0];
                list.add(item);
            }
            // Removing duplicates
            Set<String> set = new HashSet<String>(list);
            String[] resultValues = new String[set.size()];
            set.toArray(resultValues);
            // Printing out all the items in the system, removing duplicates
            // Perhaps I shouldn't have used a text document as a database.
            for (String s : resultValues) {
                System.out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    // Displays User's bid
    @Override
    public void displayUsersBids(String Username) {
        // Gets all the items on which a user has a bid
        // User login in and selects an Item
        String tmp[] = null;
        Scanner filez = null;
        try {
            filez = new Scanner(fileName);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
        }
        String format = "%1$-16s%2$-16s\n";
        System.out.format(format, "Item", "Bid Price");
        format = "|%1$-15s|%2$-15s|\n";
        while (filez.hasNextLine()) {
            final String lineFromFile = filez.nextLine();
            if (lineFromFile.contains(Username)) {
                tmp = lineFromFile.split("\t");
                System.out.format(format, tmp[0], "£" + tmp[1]);
            }
        }
    }

}
