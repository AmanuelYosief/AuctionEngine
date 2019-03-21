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
    public void PlaceBid(String item, long price, String bidder);
    public String getCurrentBid(String item);
    public boolean checkItem(String item); 
    public boolean stringContainsNumber(String s);
    public int getMaxValue(String item) throws FileNotFoundException;
    public void DisplayItems();
    public void displayItem();
    public void displayUsersBids(String Username);
    
}
