package com.ceva.jpersis.ch03.validation;


import javax.validation.constraints.*;
import java.util.Date;

public class Item {

    @NotNull
    @NotBlank
    @NotEmpty
    @Size(
            min = 2,
            max = 255,
            message = "Name is required, maximum 255 characteres."
    )
    private String name;

    @Future
    private Date auctionEnd;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getAuctionEnd() {
        return auctionEnd;
    }

    public void setAuctionEnd(Date auctionEnd) {
        this.auctionEnd = auctionEnd;
    }
}
