/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Amanuel
 */
public class AuctionEngine {

    // The person making the bid
//  private final Person bidder;
    // The value of the bid. This is always higher than before
    final long value = 0;
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
    
    List<Triplet<String, String, Integer>> Bids = new ArrayList<>();
    // machine indepedent text document database to store all the items and bids on them
    File file = new File("AuctionDb.txt");
    FileWriter fileWriter = new FileWriter(file);
    
    System.out.println("Welcome to the Auction Engine");
    
    
     
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
    
    
}
    
}
