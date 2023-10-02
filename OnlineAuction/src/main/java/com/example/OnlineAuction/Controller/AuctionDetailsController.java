package com.example.OnlineAuction.Controller;

import com.example.OnlineAuction.Auction.Auction;
import com.example.OnlineAuction.Auction.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Controller
public class AuctionDetailsController {

    @Autowired
    private AuctionRepository auctionRepository;

    // Add this method to your controller
    @GetMapping("/auction/{id}")
    public String auctionDetails(@PathVariable Long id, Model model) {
        // Retrieve the specific auction from the database
        Optional<Auction> auctionOptional = auctionRepository.findById(Math.toIntExact(id));

        // Check if the auction exists
        if (auctionOptional.isPresent()) {
            Auction auction = auctionOptional.get();
            model.addAttribute("auction", auction);
            return "auctiondetails";
        } else {
            // Handle the case where the auction is not found
            return "redirect:/dashboard";
        }
    }

}
