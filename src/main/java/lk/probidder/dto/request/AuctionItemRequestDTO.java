package lk.probidder.dto.request;

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
public class AuctionItemRequestDTO {
    private Long id;

    private String description;

    private double startingBid;

    private double reservePrice;

    private Date startTime;

    private Date endTime;

    private boolean active;

    private UserDTO seller;

}
