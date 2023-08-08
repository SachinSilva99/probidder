package lk.probidder.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class AuctionItemOrder extends OrderItem {
    @ManyToOne
    @JoinColumn(name = "auction_item_id")
    private AuctionItem auctionItem;


    @Column
    private long auctionItemQty;
}
