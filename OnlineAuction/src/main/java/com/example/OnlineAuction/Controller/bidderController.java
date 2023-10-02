package auction.demo.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import auction.demo.model.bidder;
import auction.demo.model.Auction;
import auction.demo.repository.bidderrepository;
import auction.demo.repository.auctionrepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;



@Controller
@RequestMapping("/bidders")
public class bidderController {

    private final bidderrepository bidderRepository;
    private  auctionrepository auctionRepository;


    @Autowired
    public bidderController(bidderrepository bidderRepository) {

        this.bidderRepository = bidderRepository;
    }

    // Create a new bidder
    @PostMapping
    public bidder createBidder(@RequestBody bidder newBidder) {

        return bidderRepository.save(newBidder);
    }



    @GetMapping("/new")
    public String showBidderForm(Model model) {
        model.addAttribute("bidders1", new bidder());
        return "bidderForm"; // This should match the name of your Thymeleaf template for the bidder form (e.g., bidderForm.html)
    }

    // Create a new bidder
    @PostMapping("/create")
    public String createBidder(@ModelAttribute bidder bidder1, RedirectAttributes redirectAttributes) {
        bidderRepository.save(bidder1);
        redirectAttributes.addFlashAttribute("message", "Bidder created successfully!");
        return "redirect:/bidders/list"; // Redirect to the list of bidders after creating a new bidder
    }

    // Display the list of bidders
    @GetMapping("/list")
    public String listBidders(Model model) {
        List<bidder> bidders = bidderRepository.findAll();
        model.addAttribute("bidders", bidders);
        return "bidder"; // Assuming you have a Thymeleaf template for listing bidders
    }


    @GetMapping("/{id}")
    public Optional<bidder> getBidderById(@PathVariable Integer id) {

        return bidderRepository.findById(id);
    }

    // Update a bidder by ID
    @PutMapping("/{id}")
    public bidder updateBidder(@PathVariable Integer id, @RequestBody bidder updatedBidder) {
        return bidderRepository.findById(id)
                .map(bidder -> {
                    bidder.setUsername(updatedBidder.getUsername());
                    bidder.setEmail(updatedBidder.getEmail());
                    bidder.setPassword(updatedBidder.getPassword());
                    bidder.setBalance(updatedBidder.getBalance());
                    // Set other properties as needed
                    return bidderRepository.save(bidder);
                })
                .orElseGet(() -> {
                    updatedBidder.setBid(id);
                    return bidderRepository.save(updatedBidder);
                });
    }

    // Delete a bidder by ID
    @DeleteMapping("/{id}")
    public void deleteBidder(@PathVariable Integer id) {
        bidderRepository.deleteById(id);
    }

    // Display the watchlist for a bidder
    @GetMapping("/{bidderId}/watchlist")
    public String viewWatchlist(@PathVariable int bidderId, Model model) {
        Optional<bidder> optionalBidder = bidderRepository.findById(bidderId);

        if (optionalBidder.isPresent()) {
            bidder bidder = optionalBidder.get();
            List<Auction> watchlist = bidder.getWatchlist();
            model.addAttribute("watchlist", watchlist);
            model.addAttribute("bidderId", bidderId);
            return "watchlist";
        } else {
            // Handle bidder not found
            return "error"; // You can create an error.html template
        }
    }

    // Handle placing a bid on an auction from the watchlist

    // Handle placing a bid on an auction from the watchlist
    @PostMapping("/place-bid")
    public String placeBid(@RequestParam int bidderId, @RequestParam int auctionId, @RequestParam double bidAmount) {
        Optional<bidder> optionalBidder = bidderRepository.findById(bidderId);
        Optional<Auction> optionalAuction = auctionRepository.findById(auctionId);

        if (optionalBidder.isPresent() && optionalAuction.isPresent()) {
            bidder bidder1 = optionalBidder.get();
            Auction auction = optionalAuction.get();
            bidder1.placeBid(auction, bidAmount);
            bidderRepository.save(bidder1);
        } else {
            // Handle bidder or auction not found
        }

        return "redirect:/bidders/{bidderId}/watchlist";
    }

}
