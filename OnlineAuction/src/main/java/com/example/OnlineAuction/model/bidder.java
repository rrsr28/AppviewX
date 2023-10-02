package auction.demo.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="bidder")
public class bidder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int bid;
    @Column
    private String username;
    private String email;
    private String password;
    private double balance;

    @ManyToMany
    @JoinTable(
            name = "watchlist",
            joinColumns = @JoinColumn(name = "bid"),
            inverseJoinColumns = @JoinColumn(name = "aid")
    )
    private List<Auction> watchlist;
    public bidder() {
        // Initialize any default values here if needed
        this.watchlist = new ArrayList<>();
    }

    public bidder(String username, String email, String password) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.balance = 0.0; // Initialize balance to zero
        this.watchlist = new ArrayList<>();
    }


    // Getter and Setter methods for username
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    // Getter and Setter methods for email
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // Getter and Setter methods for password
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    // Getter and Setter methods for balance
    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    // Getter and Setter methods for watchlist
    public List<Auction> getWatchlist() {
        return watchlist;
    }

    public void setWatchlist(List<Auction> watchlist) {
        this.watchlist = watchlist;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited $" + amount + " into your account. New balance: $" + balance);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public  void addToWatchlist(Auction auction) {
        watchlist.add(auction);
        System.out.println("Added auction '" + auction.getTitle() + "' to your watchlist.");
    }

    public void placeBid(Auction auction, double bidAmount) {
        if (bidAmount > balance) {
            System.out.println("Insufficient funds to place this bid.");
            return;
        }

        if (auction.getCurrentBid() >= bidAmount) {
            System.out.println("Your bid must be higher than the current bid.");
            return;
        }

        if (!watchlist.contains(auction)) {
            System.out.println("You can only bid on auctions in your watchlist.");
            return;
        }

        auction.setCurrentBid(bidAmount);
        System.out.println("Bid placed successfully: $" + bidAmount + " on auction '" + auction.getTitle() + "'.");
        balance -= bidAmount;
    }

    public void setBid(Integer id) {
        this.bid=id;
    }
}

