package lk.probidder.util.mapper;

import lk.probidder.dto.AuctionItemDTO;
import lk.probidder.entity.AuctionItem;
import lk.probidder.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


/*
Author : Sachin Silva
*/
@Mapper(componentModel = "spring")
public interface AuctionItemMapper {
    AuctionItem toAuctionItem(AuctionItemDTO auctionItemDTO);

    @Mapping(source = "seller", target = "sellerId")
    AuctionItemDTO toAuctionItemDto(AuctionItem auctionItem);

    default Long sellerToSellerId(User seller) {
        return seller != null ? seller.getId() : null;
    }
}