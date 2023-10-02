package com.example.OnlineAuction.Controller;

import com.example.OnlineAuction.Auction.Auction;
import com.example.OnlineAuction.Auction.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class DashboardController {

    @Autowired
    private AuctionRepository auctionRepository;

    @GetMapping("/dashboard")
    public String dashboard(Model model) {
        // Retrieve available auctions from the database
        List<Auction> availableAuctions = auctionRepository.findAll();

        // Add the list of auctions to the model for display
        model.addAttribute("availableAuctions", availableAuctions);

        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout() {
        // Perform any necessary logout actions (e.g., clearing session attributes)
        return "redirect:/login";  // Redirect to the login page after logout
    }
}