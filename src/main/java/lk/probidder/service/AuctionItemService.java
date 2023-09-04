package lk.probidder.service;

import lk.probidder.dto.AuctionItemDTO;

import java.util.List;

/*
Author : Sachin Silva
*/
public interface AuctionItemService {
    AuctionItemDTO getAuctionItemDto(Long id) throws ClassNotFoundException;

    List<AuctionItemDTO> getAuctionItemsByActive(boolean active);
    List<AuctionItemDTO>getItemDtoList();
    List<AuctionItemDTO>searchItemDtoByDesOrId(String description, Long id);
    String createAuctionItem(AuctionItemDTO auctionItemRequestDTO);
    void deleteAuctionItem(Long id)throws ClassNotFoundException;

}
