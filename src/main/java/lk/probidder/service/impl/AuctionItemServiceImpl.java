package lk.probidder.service.impl;

import jakarta.transaction.Transactional;
import lk.probidder.dto.AuctionItemDTO;
import lk.probidder.dto.request.AuctionItemRequestDTO;
import lk.probidder.dto.response.AuctionItemResponseDTO;
import lk.probidder.entity.AuctionItem;
import lk.probidder.repo.AuctionItemRepo;
import lk.probidder.service.AuctionItemService;
import lk.probidder.util.mapper.AuctionItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/*
Author : Sachin Silva
*/
@Service
public class AuctionItemServiceImpl implements AuctionItemService {
    @Autowired
    AuctionItemRepo auctionItemRepo;

    @Autowired
    AuctionItemMapper auctionItemMapper;

    @Override
    public AuctionItemResponseDTO getAuctionItemDto(Long id) throws ClassNotFoundException {
        Optional<AuctionItem> byId = auctionItemRepo.findById(id);
        if (byId.isPresent()) {
            return auctionItemMapper.toItemResponseDto(byId.get());
        }
        throw new ClassNotFoundException();
    }

    @Override
    public List<AuctionItemResponseDTO> getAuctionItemsByActive(boolean active) {
        List<AuctionItem> auctionItems = auctionItemRepo.searchAuctionItemsByActive(active);
        return auctionItemMapper.toAuctionItemResponseDTOs(auctionItems);
    }

    @Override
    public List<AuctionItemResponseDTO> getItemDtoList() {
        return auctionItemMapper.toAuctionItemResponseDTOs(auctionItemRepo.findAll());

    }

    @Override
    public List<AuctionItemResponseDTO> searchItemDtoByDesOrId(String description, Long id) {
        return auctionItemMapper.
                toAuctionItemResponseDTOs(auctionItemRepo.searchAllByDescriptionContainsOrIdContains(description, id));
    }

    @Override
    @Transactional
    public String createAuctionItem(AuctionItemRequestDTO dto) {
        AuctionItemDTO auctionItemDTO = new AuctionItemDTO(
                dto.getDescription(),
                dto.getStartingBid(),
                dto.getReservePrice(),
                dto.getStartTime(),
                dto.getEndTime(),
                dto.isActive(),
                dto.getSeller()
        );
        System.out.println(dto);
        AuctionItem auctionItem = auctionItemMapper.toAuctionItem(auctionItemDTO);
        System.out.println(auctionItem);

        return auctionItemRepo.save(auctionItem).getId() + " saved";
    }

    @Override
    public void deleteAuctionItem(Long id) {
        Optional<AuctionItem> byId = auctionItemRepo.findById(id);
        byId.ifPresent(auctionItem -> auctionItemRepo.delete(auctionItem));
    }

}
