package com.example.OnlineAuction.Auction;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuctioneerRepository extends JpaRepository<Auctioneers, Integer>
{
    // Custom queries if needed
}