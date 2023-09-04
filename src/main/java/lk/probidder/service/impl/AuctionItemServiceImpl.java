package lk.probidder.service.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lk.probidder.dto.AuctionItemDTO;
import lk.probidder.entity.AuctionItem;
import lk.probidder.repo.AuctionItemRepo;
import lk.probidder.service.AuctionItemService;
import lk.probidder.util.mapper.AuctionItemMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    public AuctionItemDTO getAuctionItemDto(Long id) throws ClassNotFoundException {
        Optional<AuctionItem> byId = auctionItemRepo.findById(id);
        if (byId.isPresent()) {
            return auctionItemMapper.toAuctionItemDto(byId.get());
        }
        throw new ClassNotFoundException();
    }

    @Override
    public List<AuctionItemDTO> getAuctionItemsByActive(boolean active) {
        List<AuctionItem> auctionItems = auctionItemRepo.searchAuctionItemsByActive(active);
        return auctionItems
                .stream()
                .map(auctionItem -> auctionItemMapper.toAuctionItemDto(auctionItem))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuctionItemDTO> getItemDtoList() {
        return auctionItemRepo
                .findAll()
                .stream()
                .map(ai -> auctionItemMapper.toAuctionItemDto(ai))
                .collect(Collectors.toList());
    }

    @Override
    public List<AuctionItemDTO> searchItemDtoByDesOrId(String description, Long id) {
        return auctionItemRepo
                .searchAllByDescriptionContainsOrIdContains(description, id)
                .stream()
                .map(auctionItem -> auctionItemMapper.toAuctionItemDto(auctionItem))
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public String createAuctionItem(AuctionItemDTO auctionItemDTO) {
        return auctionItemRepo
                .save(auctionItemMapper.toAuctionItem(auctionItemDTO)).getId() + " saved";
    }

    @Override
    public void deleteAuctionItem(Long id) {
        Optional<AuctionItem> byId = auctionItemRepo.findById(id);
        if (byId.isEmpty()) {
            throw new EntityNotFoundException(id + " is not available");
        }
        byId.ifPresent(auctionItem -> auctionItemRepo.delete(auctionItem));
    }


}
