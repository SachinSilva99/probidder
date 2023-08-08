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
@Table(name = "buy_direct_items")
public class BuyDirectItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String itemName;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private double price;

    @Column(nullable = false)
    private long qtyOnHand;

    @ManyToOne
    @JoinColumn(name = "seller_id", referencedColumnName = "id")
    private User seller;

    @OneToMany
    private List<Review> reviews = new ArrayList<>();

    @OneToMany(mappedBy = "buyDirectItem")
    private List<BuyDirectItemOrder> buyDirectItemOrders = new ArrayList<>();
}
