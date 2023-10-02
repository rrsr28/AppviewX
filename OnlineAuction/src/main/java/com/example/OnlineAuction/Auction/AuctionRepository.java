package com.example.OnlineAuction.Auction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctionRepository extends JpaRepository<Auction, Integer>
{
    // Custom queries if needed
}