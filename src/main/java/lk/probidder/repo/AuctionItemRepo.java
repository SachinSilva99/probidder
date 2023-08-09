package lk.probidder.repo;

import lk.probidder.entity.AuctionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/*
Author : Sachin Silva
*/
public interface AuctionItemRepo extends JpaRepository<AuctionItem,Long> {
    boolean findAuctionItemByActive(boolean active);
    AuctionItem findAuctionItemByDescription(String description);
    List<AuctionItem> searchAllByDescriptionContainsOrIdContains(String description, Long id);
    List<AuctionItem> searchAuctionItemsByActive(boolean active);
}
