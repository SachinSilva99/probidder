package lk.probidder.util.mapper;

import lk.probidder.dto.AuctionItemDTO;
import lk.probidder.entity.AuctionItem;
import org.mapstruct.Mapper;

/*
Author : Sachin Silva
*/
@Mapper(componentModel = "spring")
public interface AuctionItemMapper {
    AuctionItem toAuctionItem(AuctionItemDTO auctionItemDTO);

    AuctionItemDTO toAuctionItemDto(AuctionItem auctionItem);


}
