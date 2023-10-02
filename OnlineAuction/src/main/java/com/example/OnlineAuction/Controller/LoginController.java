package com.example.OnlineAuction.Controller;

import com.example.OnlineAuction.Auction.Auctioneers;
import com.example.OnlineAuction.Repository.AuctioneersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    @Autowired
    private AuctioneersRepository auctioneersRepository;

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<Auctioneers> userOptional = auctioneersRepository.findByNameAndPassword(username, password);

        if (userOptional.isPresent()) {
            return "redirect:/dashboard";
        } else {
            return "redirect:/signup";
        }
    }
}
