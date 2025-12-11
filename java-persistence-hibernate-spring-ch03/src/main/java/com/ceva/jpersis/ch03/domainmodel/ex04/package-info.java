/**
 * Global Hibernate annotation @NamedQueries
 * Aunque se puede utilizar en una clase especifica. Esta anotacion se puede colocar de forma de metadata global
 */

@NamedQueries(
        {
                @NamedQuery(
                        name = "findItemOrderByName",
                        query = "SELECT i FROM Item i ORDER BY i.name asc"
                ),
                @NamedQuery(
                        name = "findItemBuyNowPriceGreaterThan",
                        query = "SELECT i FROM Item i WHERE i.buyNowPrice> :price",
                        timeout = 60, // seconds
                        comment = "Custom SQL comment"
                )
        }
)





package com.ceva.jpersis.ch03.domainmodel.ex04;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


