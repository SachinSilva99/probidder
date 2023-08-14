package lk.probidder.dto;

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
public class UserDTO {
    private Long id;
    private String username;
    private String email;
    private String password;
    private String phoneNumber;
    private List<RoleType> roleTypes;
    private LocalDate dob;
    private List<AuctionItemDTO> auctionItems = new ArrayList<>();
   /* private List<BuyDirectItemDTO> buyDirectItems = new ArrayList<>();
    private List<NotificationDTO> notifications = new ArrayList<>();
    private List<ReviewDTO> reviews = new ArrayList<>();*/

}
