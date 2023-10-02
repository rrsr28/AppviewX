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
public class SignupController {

    @Autowired
    private AuctioneersRepository auctioneersRepository;

    @GetMapping("/signup")
    public String signup(@RequestParam(name = "success", required = false) String success, Model model) {
        // Check for success parameter and add it to the model
        if ("true".equals(success)) {
            model.addAttribute("signupSuccess", true);
        }
        return "signup";
    }

    @PostMapping("/signup")
    public String processSignup(@RequestParam String name, @RequestParam String email, Auctioneers user, Model model) {
        // Check if the username or email already exists in the database
        Optional<Auctioneers> byName = auctioneersRepository.findByName(name);
        Optional<Auctioneers> byEmail = auctioneersRepository.findByEmail(email);

        if (byName.isPresent() || byEmail.isPresent()) {
            model.addAttribute("signupError", "Username or email already exists");
            return "signup";
        }

        // Save the user to the database
        auctioneersRepository.save(user);

        // Redirect to the dashboard after signup
        return "redirect:/dashboard";
    }
}
