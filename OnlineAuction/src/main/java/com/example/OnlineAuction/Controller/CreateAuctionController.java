package com.example.OnlineAuction.Controller;

import com.example.OnlineAuction.Auction.Auction;
import com.example.OnlineAuction.Auction.AuctionRepository;
import com.example.OnlineAuction.Service.FileUploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import java.nio.file.Path;
import java.nio.file.Paths;

@Controller
public class CreateAuctionController {

    @Autowired
    private AuctionRepository auctionRepository;

    @Autowired(required = true)
    private FileUploadService fileUploadService;


    @GetMapping("/createauction")
    public String createAuction() {
        return "createauction";
    }

    @PostMapping("/submitauction")
    public String submitAuction(@RequestParam String auctionTitle,
                                @RequestParam String description,
                                @RequestParam double startingPrice,
                                @RequestParam String startTime,
                                @RequestParam("itemImages") MultipartFile[] itemImages,
                                Model model) {

        Auction newAuction = new Auction();
        newAuction.setAuctionTitle(auctionTitle);
        newAuction.setDescription(description);
        newAuction.setStartingPrice(startingPrice);
        newAuction.setStartTime(startTime);

        try {
            // Process and save uploaded images
            List<String> imageFilenames = Arrays.stream(itemImages)
                    .map(itemImage -> {
                        try {
                            return fileUploadService.uploadFile(itemImage);
                        } catch (IOException e) {
                            // Handle the IOException for this specific image
                            e.printStackTrace(); // Log the exception if needed
                            return null; // Or some default value, or handle as appropriate
                        }
                    })
                    .filter(Objects::nonNull) // Filter out null values (failed uploads)
                    .map(filename -> Paths.get(filename).getFileName().toString()) // Extract the file name from the path
                    .collect(Collectors.toList());

            newAuction.setItemImages(String.join(",", imageFilenames));
            newAuction.setItemImageURLs(String.join(",",
                    imageFilenames.stream().map(fileName -> "C:/Users/Sanjay Ram R R/Downloads/AppviewX/OnlineAuction/images/" + fileName).collect(Collectors.toList())));

            // Save the new auction to the database
            auctionRepository.save(newAuction);

            // Add the new auction details to the model for display
            model.addAttribute("newAuction", newAuction);

            // Return to the createauction page with the new auction details
            return "createauction";
        } catch (Exception e) {
            // Catch other exceptions if necessary
            e.printStackTrace();
            model.addAttribute("error", "An unexpected error occurred: " + e.getMessage());
            return "createauction";
        }
    }
}