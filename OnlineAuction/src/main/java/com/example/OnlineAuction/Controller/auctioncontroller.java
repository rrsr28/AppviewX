
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import auction.demo.model.Auction;
import auction.demo.model.bidder;
import auction.demo.repository.bidderrepository;
import auction.demo.repository.auctionrepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/auctions")
public class auctioncontroller {

    private final auctionrepository auctionRepository;
    private final bidderrepository bidderRepository;

    @Autowired
    public auctioncontroller(auctionrepository auctionRepository, bidderrepository bidderRepository) {
        this.auctionRepository = auctionRepository;
        this.bidderRepository = bidderRepository;
    }

    @GetMapping("/list")
    public String listAuctions(Model model) {
        List<Auction> auctions = auctionRepository.findAll();
        model.addAttribute("auctions", auctions);
        return "auctionlist";
    }

    @PostMapping("/{bidderId}/add-to-watchlist/{auctionId}")
    public String addToWatchlist(@PathVariable int bidderId, @PathVariable int auctionId) {
        Optional<bidder> optionalBidder = bidderRepository.findById(bidderId);
        Optional<Auction> optionalAuction = auctionRepository.findById(auctionId);

        if (optionalBidder.isPresent() && optionalAuction.isPresent()) {
            bidder bidder1 = optionalBidder.get();
            Auction auction = optionalAuction.get();
            bidder1.addToWatchlist(auction);
            bidderRepository.save(bidder1);
        }

        return "redirect:/auctions/list";
    }


}
