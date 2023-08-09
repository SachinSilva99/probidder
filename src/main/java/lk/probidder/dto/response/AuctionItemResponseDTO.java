package lk.probidder.dto.response;

import lk.probidder.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
Author : Sachin Silva
*/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class AuctionItemResponseDTO {
    private Long id;

    private String description;

    private double startingBid;

    private double reservePrice;

    private Date startTime;

    private Date endTime;

    private boolean active;
    private Long sellerId;
    private UserDTO seller;

}
