package com.example.OnlineAuction.Repository;

import com.example.OnlineAuction.Auction.Auctioneers;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuctioneersRepository extends CrudRepository<Auctioneers, Integer> {
    Optional<Auctioneers> findByName(String name);
    Optional<Auctioneers> findByEmail(String email);
    Optional<Auctioneers> findByNameAndPassword(String name, String password);

}
