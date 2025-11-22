package com.ceva.jpersis.ch03.domainmodel.ex03;

/**
 * Bidirectional Navigation Between Objects: Bid#Item
 * Many to one relationship -> User can make many bids for each item
 */
public class Bid {
    // we can navigate from Bid to the related Item
    private Item item;

    public Bid(Item item){
        this.item = item;
        item.addBid(this); // bidireccional
    }

    public Item getItem(){
        return item;
    }

    public void setItem(Item item){
        this.item = item;
    }
}
