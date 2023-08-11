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
public class ItemOrder extends OrderHasItem {
    @ManyToOne
    @JoinColumn(name = "item_id")
    private Item item;
    @Column
    private long itemQty;
}
