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

    // Record a user's bid.
    // Each bid is higher than before
    public concreteBid() {
        ;  // Set the initial value for the class attribute x
    }

    @Override
    public void PlaceBid(String item, long price, String bidder) {
        File file = new File("AuctionEngine.txt");

        try (Writer writer = new BufferedWriter(new FileWriter(file, true))) {
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
            Scanner file = new Scanner(new File("AuctionEngine.txt"));
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    @Override
    public boolean checkItem(String item) {

        if (item.trim() == null || item.trim().equals("") || stringContainsNumber(item) == true) {
            return false;
        } else {

            boolean exists = false;
            String tmp[] = null;
            Scanner filez = null;
            try {
                filez = new Scanner(new File("AuctionEngine.txt"));
            } catch (FileNotFoundException ex) {
                Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
            }
            while (filez.hasNextLine()) {
                final String lineFromFile = filez.nextLine();
                if (lineFromFile.contains(item)) {
                    tmp = lineFromFile.split("\t");
                    exists = true;
                    // System.out.println(Arrays.asList(tmp).contains(name));
                }
                if (exists = true) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    @Override
    public boolean stringContainsNumber(String s) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher m = p.matcher(s);
        return m.find();
    }
    
    @Override
    public int getMaxValue(String item) throws FileNotFoundException {

        List<Integer> list = new ArrayList<Integer>();
        String tmp[] = null;
        Scanner filez = new Scanner(new File("AuctionEngine.txt"));

        while (filez.hasNextLine()) {
            final String lineFromFile = filez.nextLine();
            if (lineFromFile.contains(item)) {
                tmp = lineFromFile.split("\t");
                int price = Integer.parseInt(tmp[1]);
                list.add(price);
            }
        }
        return Collections.max(list);
    }
    
    @Override
    public void DisplayItems() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("AuctionEngine.txt"));
            String line = null;
            System.out.println("\r\n" + "     ---Auction Items----     ");
            String format = "%1$-16s%2$-16s%3$-1s\n";
            System.out.format(format, "Item", "Bid Price", "Bidder");
            while ((line = br.readLine()) != null) {
                String tmp[] = line.split("\t");
                String item = tmp[0];
                long bidPrice = Integer.parseInt(tmp[1]);
                String name = tmp[2];
                // System.out.println(item + "\t" + bidPrice + "\t" + name);
                format = "|%1$-15s|%2$-15s|%3$-10s|\n";
                System.out.format(format, item, "£" + bidPrice, name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
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
    
    // DONE
    @Override
    public void displayUsersBids(String Username){
        // Gets all the items on which a user has a bid
        // User login in and selects an Item
        String tmp[] = null;
        Scanner filez = null;
        try {
            filez = new Scanner(new File("AuctionEngine.txt"));
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
