package lk.probidder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionItemDTO {
    private Long id;

    private String description;

    private double startingBid;

    private double reservePrice;

    private Date startTime;

    private Date endTime;

    private boolean active;

    private UserDTO seller;


//    private List<BidDTO> bids = new ArrayList<>();

//    private List<ReviewDTO> reviews = new ArrayList<>();

//    private List<AuctionItemOrderDTO> auctionItemOrders = new ArrayList<>();

    public AuctionItemDTO(String description, double startingBid, double reservePrice, Date startTime, Date endTime, boolean active, UserDTO sellerId) {
        this.description = description;
        this.startingBid = startingBid;
        this.reservePrice = reservePrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.active = active;
        this.seller = sellerId;
    }
}
