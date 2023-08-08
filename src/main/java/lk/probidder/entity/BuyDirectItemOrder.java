package lk.probidder.entity;

import jakarta.persistence.*;
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
public class BuyDirectItemOrder extends OrderItem {
    @ManyToOne
    @JoinColumn(name = "buy_direct_item_id")
    private BuyDirectItem buyDirectItem;
    @Column
    private long buyDirectItemQty;
}
