package lk.probidder.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "order_detail")
public class OrderDetail {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(
            name = "buy_direct_item_id"
    )
    private BuyDirectItem buyDirectItem;

    @Column
    private long buyDirectItemQty;

    @ManyToOne
    @JoinColumn(
            name = "auction_item_id"
    )
    private AuctionItem auctionItem;

    @Column
    private long auctionItemQty;
}
