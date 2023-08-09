package lk.probidder.util.mapper;

import lk.probidder.dto.AuctionItemDTO;
import lk.probidder.dto.response.AuctionItemResponseDTO;
import lk.probidder.entity.AuctionItem;
import org.mapstruct.Mapper;

import java.util.List;

/*
Author : Sachin Silva
*/
@Mapper(componentModel = "spring")
public interface AuctionItemMapper {
    AuctionItem toAuctionItem(AuctionItemDTO auctionItemDTO);

    AuctionItemResponseDTO toItemResponseDto(AuctionItem auctionItem);

    List<AuctionItemResponseDTO> toAuctionItemResponseDTOs(List<AuctionItem> auctionItems);
}
