package lk.probidder.api;

import lk.probidder.dto.request.AuctionItemRequestDTO;
import lk.probidder.dto.response.AuctionItemResponseDTO;
import lk.probidder.service.AuctionItemService;
import lk.probidder.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/*
Author : Sachin Silva
*/
@RestController
@RequestMapping("/api/auction-item")
public class AuctionItemController {
    @Autowired
    private AuctionItemService service;

    @PostMapping(value = "/create",
            consumes = {MediaType.APPLICATION_JSON_VALUE},
            produces = {MediaType.APPLICATION_JSON_VALUE}
    )
    public ResponseEntity<StandardResponse> save(@RequestBody AuctionItemRequestDTO dto) {
        System.out.println(dto);
        String auctionItemId = service.createAuctionItem(dto);
        return new ResponseEntity<>(
                new StandardResponse(
                        201,
                        auctionItemId,
                        auctionItemId
                ), HttpStatus.CREATED
        );
    }

    @DeleteMapping("/remove/{id}")
    public ResponseEntity<AuctionItemResponseDTO> delete(@PathVariable Long id) {
        service.deleteAuctionItem(id);
        return ResponseEntity.noContent().build();
    }
}
