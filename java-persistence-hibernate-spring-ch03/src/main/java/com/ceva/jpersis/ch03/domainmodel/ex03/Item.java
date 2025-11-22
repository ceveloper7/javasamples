package com.ceva.jpersis.ch03.domainmodel.ex03;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Bidirectional Navigation Between Objects: Item#Bid
 * One to Many relationship -> One Item can have many Bids
 */
public class Item {
    // we can navigate from item to the related bid
    private Set<Bid> bids = new HashSet<Bid>();

    public Set<Bid> getBids(){
        return Collections.unmodifiableSet(bids);
    }

    public void addBid(Bid bid){
        if(bid == null)
            throw new NullPointerException("Can not add a null bid");

        if (bid.getItem() != null)
            throw new IllegalStateException("Bid is already assigned to an Item");

        bids.add(bid);
        bid.setItem(this);
    }
}
