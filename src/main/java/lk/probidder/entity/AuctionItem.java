package lk.probidder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "auction_item")
public class AuctionItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double startingBid;

    @Column(nullable = false)
    private double reservePrice;

    @Column(nullable = false)
    private Date startTime;

    @Column(nullable = false)
    private Date endTime;

    @Column(nullable = false)
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id", nullable = false)
    private User seller;

    @OneToMany(mappedBy = "auctionItem")
    private List<Bid> bids = new ArrayList<>();

    @OneToMany(mappedBy = "auctionItem")
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "auctionItem")
    private List<AuctionItemOrder> auctionItemOrders = new ArrayList<>();
}
