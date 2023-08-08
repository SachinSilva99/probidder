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
@Table(name = "order_items")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
