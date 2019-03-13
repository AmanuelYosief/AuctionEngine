/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package auctionengine;

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
    public int PlaceBid(Person bidder, long value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    
}
