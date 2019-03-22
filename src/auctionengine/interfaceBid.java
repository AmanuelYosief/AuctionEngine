/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

import java.io.FileNotFoundException;
/**
 *A class that models an auction bid
 *Contains a reference to the Person bidding and the amount bid
 * @author Amanuel
 */
public interface interfaceBid {
    // Records a User's bid
    public void placeBid(String item, int price, String bidder);
    // Gets the current bid for an item
    public String getCurrentBid(String item);
    // Check the item exists so that a bid can be placed
    public boolean checkItem(String item); 
    // Ensure inputs don't contain integers
    public boolean stringContainsNumber(String s);
    // Get maximum bid price set on an item
    public int getMaxValue(String item) throws FileNotFoundException;
    // Display all the bidders for all items
    public void displayAllItems();
    // Display all the items available to be bidded on
    public void displayItem();
    // Displayers User's bid
    public void displayUsersBids(String Username);
    
}
