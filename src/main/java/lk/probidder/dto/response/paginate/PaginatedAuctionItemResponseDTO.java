package lk.probidder.dto.response.paginate;

import lk.probidder.dto.response.AuctionItemResponseDTO;
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
public class PaginatedAuctionItemResponseDTO {
    private long dataCount;
    private List<AuctionItemResponseDTO> dataList = new ArrayList<>();
}
