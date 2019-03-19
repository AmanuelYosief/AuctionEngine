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
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        BufferedReader br;
        String line = null;
        BufferedWriter writer;
        String file = "AuctionEngine.txt";
        try {
            br = new BufferedReader(new FileReader("AuctionEngine.txt"));

            while ((line = br.readLine()) != null) {
                if (line.contains(item)) {
                    String updatedMessage = item + "\t" + price + "\t" + bidder;
                    System.out.println(updatedMessage);
                    List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("AuctionEngine.txt", ""), StandardCharsets.UTF_8));

                    for (int i = 0; i < fileContent.size(); i++) {
                        if (fileContent.get(i).equals(line)) {
                            fileContent.set(i, updatedMessage);
                            break;
                        }
                    }
                    Files.write(Paths.get("AuctionEngine.txt", ""), fileContent, StandardCharsets.UTF_8);
                    // <editor-fold>                   

                    /*    
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("AuctionEngine.txt", true))) {
			bw.write(updatedMessage);
			System.out.println("Done");
		} catch (IOException e) {
			e.printStackTrace();
		}
                    
                    
                    
                       break;
                } else {

                }

            }
                     */
 /*   

        try {
            List<String> fileContent = new ArrayList<>(Files.readAllLines(Paths.get("AuctionEngine.txt", ""), StandardCharsets.UTF_8));
            
            for (int i = 0; i < fileContent.size(); i++) {
                System.out.println(fileContent.get(i).toString());
                    if (fileContent.get(i).equals(item)) {
                        
                    fileContent.set(i, item + "\t" + 3500 + "\t" + bidder);
                    System.out.println(bidder + item + price);
                    
                    break;
                }
            }
            Files.write(Paths.get("AuctionEngine.txt", ""), fileContent, StandardCharsets.UTF_8);
            System.out.println(fileContent.toString());
            

            File file = new File("AuctionEngine.txt");
            try (Writer writer = new BufferedWriter(new FileWriter(file, true))) {
            writer.write(item + "\t" + price + "\t" + bidder + "\r\n");
            } catch (IOException e) {
            e.printStackTrace();
            }

            
            //To change body of generated methods, choose Tools | Templates.
        } catch (IOException ex) {
            Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
        }
            
                     */
                    // </editor-fold>
                }

            } 
        } catch (FileNotFoundException ex) {
            Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(concreteBid.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
    
    
    
    // Get the current winning bid for an item
    @Override
    public void getCurrentBid(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    // Get all the bids for an item
    @Override
    public void getAllBids(Item item) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    // Get all the items on which a user has bid
    @Override
    public void getAllBidsPerson(Person bidder) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    @Override
    public void readFile(String filename) throws FileNotFoundException, IOException{
    
    try {
        BufferedReader br = new BufferedReader(new FileReader("AuctionEngine.txt"));
        String line = null;
        System.out.println("\r\n"+ "Current Bids ");
         String format = "%1$-16s%2$-16s%3$-1s\n";
           System.out.format(format, "Item", "Bid Price", "Bidder");
        while ((line = br.readLine()) != null) {
            String tmp[] = line.split("\t");
            String item = tmp[0];
            long bidPrice = Integer.parseInt(tmp[1]);
            String name = tmp[2];
            // System.out.println(item + "\t" + bidPrice + "\t" + name);

            format = "|%1$-15s|%2$-15s|%3$-10s|\n";
            System.out.format(format, item, "£"+bidPrice, name);
            
        }
    } catch (Exception e) {
    }

}

    @Override
    public boolean checkItem(String item) { 
        try {
            BufferedReader br = new BufferedReader(new FileReader("AuctionEngine.txt"));
            String line = null;

            while ((line = br.readLine()) != null) {
                String tmp[] = line.split("\t");
              //  System.out.println(Arrays.toString(tmp));
                if (Arrays.asList(tmp).contains(item.trim())) {
                    
                    ;
                   System.out.println("That bid item exists");
                    return true;
                } else {
                    System.out.println("Bid item doesn't exist, do you want to add and place a bid on it?");
                    return false;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
