package auction.demo.model;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Auction")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aid;

    @Column
    private String title;
    private String description;
    private double currentBid;
    private double minimumBidIncrement;

    // Add fields for start and end time
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private long remainingTime;
    private boolean active; // Added field

    @ManyToMany(mappedBy = "watchlist")
    private List<bidder> bidders;

    public Auction() {
        this.bidders = new ArrayList<>();
    }

    public Auction(String title, String description, double currentBid, LocalDateTime startTime, LocalDateTime endTime) {
        this.title = title;
        this.description = description;
        this.currentBid = currentBid;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getCurrentBid() {
        return currentBid;
    }

    public void setCurrentBid(double currentBid) {
        this.currentBid = currentBid;
    }

    public String getTitle() {
        return title;
    }

    public int getAid() {
        return aid;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    // Calculate remaining time based on the current time
    public double getRemainingTime() {
        LocalDateTime now = LocalDateTime.now();
        Duration duration = Duration.between(now, endTime);

        // Convert the remaining time to seconds
        double remainingTimeInSeconds = duration.getSeconds();

        // Ensure the remaining time is never negative
        return Math.max(0, remainingTimeInSeconds);
    }

    public void setRemainingTime(long secondsRemaining) {
        this.remainingTime = secondsRemaining;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }
}
