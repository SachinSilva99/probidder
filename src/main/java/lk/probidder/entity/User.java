package lk.probidder.entity;

import jakarta.persistence.*;
import lk.probidder.entity.enums.Role;
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
@Table(name = "user")
public class User {
    @Id
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Role role;

    @Column(nullable = false)
    private Date dob;

    @OneToMany
    private List<AuctionItem> auctionItems = new ArrayList<>();

    @OneToMany
    private List<Notification> notifications = new ArrayList<>();

    @OneToMany
    private List<Review> reviews = new ArrayList<>();
}
