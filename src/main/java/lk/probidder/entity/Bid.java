package lk.probidder.entity;

import jakarta.persistence.*;
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
@Entity
@Table(name = "bid")
public class Bid {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User bidder;

    @ManyToOne
    @JoinColumn(name = "winning_bidder_id", referencedColumnName = "id")
    private User winningBidder;

    @ManyToOne
    @JoinColumn(name = "auction_item_id", referencedColumnName = "id")
    private AuctionItem auctionItem;

    @Column(nullable = false)
    private double bidAmount;

    @Column(nullable = false)
    private Date timestamp;

}
