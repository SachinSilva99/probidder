package lk.probidder.entity;

import jakarta.persistence.*;
import lk.probidder.entity.enums.RoleType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Lob
    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column
    @Enumerated
    private List<RoleType> roleTypes;

    @Column(nullable = false)
    private LocalDate dob;

    @OneToMany(mappedBy = "seller")
    private List<AuctionItem> auctionItems = new ArrayList<>();

    @OneToMany(mappedBy = "seller")
    private List<Item> items = new ArrayList<>();

    @OneToMany(mappedBy = "recipient")
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany(mappedBy = "buyer")
    private List<Review> reviews = new ArrayList<>();
}
