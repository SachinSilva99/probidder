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
@Table(name = "order_has_item")
@Inheritance(strategy = InheritanceType.JOINED)
public class OrderHasItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
}
