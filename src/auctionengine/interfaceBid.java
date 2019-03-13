/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

/**
 *A class that models an auction bid
 *Contains a reference to the Person bidding and the amount bid
 * @author Amanuel
 */
public interface interfaceBid {
    // Record a user's bid.
    // Each bid is higher than before
    public int PlaceBid(Person bidder,long value);
    // Get the current winning bid for an item
    public void getCurrentBid(Item item);
    // Get all the bids for an item
    public void getAllBids(Item item);
    // Get all the items on which a user has bid
    public void getAllBidsPerson(Person bidder);
    
}
