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
public class Triplet<Person, Item, Price> {

    private final Person first;
    private final Item second;
    private final Price third;

    public Triplet(Person first, Item second, Price third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Person getFirst() { return first; }
    public Item getSecond() { return second; }
    public Price getPrice() { return third; }
    
}