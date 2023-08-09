package lk.probidder.service;

import lk.probidder.dto.request.AuctionItemRequestDTO;
import lk.probidder.dto.response.AuctionItemResponseDTO;

import java.util.List;

/*
Author : Sachin Silva
*/
public interface AuctionItemService {
    AuctionItemResponseDTO getAuctionItemDto(Long id) throws ClassNotFoundException;

    List<AuctionItemResponseDTO> getAuctionItemsByActive(boolean active);
    List<AuctionItemResponseDTO>getItemDtoList();
    List<AuctionItemResponseDTO>searchItemDtoByDesOrId(String description, Long id);
    String createAuctionItem(AuctionItemRequestDTO auctionItemRequestDTO);
    void deleteAuctionItem(Long id);

}
