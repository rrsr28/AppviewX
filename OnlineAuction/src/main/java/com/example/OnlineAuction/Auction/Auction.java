package com.example.OnlineAuction.Auction;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.List;

@Entity
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "Title")
    private String auctionTitle;

    @Column(name = "Description")
    private String description;

    @Column(name = "StartingPrice")
    private double startingPrice;

    @Column(name = "CurrentPrice")
    private double currentPrice;

    @Column(name = "FinalPrice")
    private double finalPrice;

    @Column(name = "StartTime")
    private String startTime;

    @Column(name = "EndTime")
    private String endTime;

    // Assuming you are storing image paths as a comma-separated string
    @Column(name = "ItemImages")
    private String itemImages;

    @Column(name = "ItemImageURLs")
    private String itemImageURLs;

    // Getter and Setter methods

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuctionTitle() {
        return auctionTitle;
    }

    public void setAuctionTitle(String auctionTitle) {
        this.auctionTitle = auctionTitle;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public void setStartingPrice(double startingPrice) {
        this.startingPrice = startingPrice;
    }

    public double getCurrentPrice() {
        return currentPrice;
    }

    public void setCurrentPrice(double currentPrice) {
        this.currentPrice = currentPrice;
    }

    public double getFinalPrice() {
        return finalPrice;
    }

    public void setFinalPrice(double finalPrice) {
        this.finalPrice = finalPrice;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getItemImages() {
        return itemImages;
    }

    public void setItemImages(String itemImages) {
        this.itemImages = itemImages;
    }

    public String getItemImageURLs() {
        return itemImageURLs;
    }

    public void setItemImageURLs(String itemImageURLs) {
        this.itemImageURLs = itemImageURLs;
    }

    public Auction()
    {
    }

    public Auction(int id, String auctionTitle, String description, double startingPrice, double currentPrice, double finalPrice, String startTime, String endTime, String itemImages, String itemImageURLs) {
        this.id = id;
        this.auctionTitle = auctionTitle;
        this.description = description;
        this.startingPrice = startingPrice;
        this.currentPrice = currentPrice;
        this.finalPrice = finalPrice;
        this.startTime = startTime;
        this.endTime = endTime;
        this.itemImages = itemImages;
        this.itemImageURLs = itemImageURLs;
    }
}
