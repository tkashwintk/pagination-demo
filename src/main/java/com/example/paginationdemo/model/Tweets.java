package com.example.paginationdemo.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NaturalId;
import java.time.Instant;
import java.util.Objects;

@Entity
@Table(name = "tweet")
@Getter
@Setter
public class Tweets {

    public Tweets() {
        this.createdAt = Instant.now();
    }

    public Tweets(String postedBy, String tweet, String status) {
        this.postedBy = postedBy;
        this.tweet = tweet;
        this.status = status;
        this.createdAt = Instant.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "posted_by")
    private String postedBy;

    @Column(name = "tweet")
    private String tweet;

    @Column(name = "status")
    private String status;

    @Column(name = "createdAt")
    private Instant createdAt;

    @Override
    public String toString() {
        return "Tweets{" +
                "id=" + id +
                ", postedBy='" + postedBy + '\'' +
                ", tweet='" + tweet + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tweets)) return false;
        Tweets tweets = (Tweets) o;
        return Objects.equals(getId(), tweets.getId()) && Objects.equals(getPostedBy(), tweets.getPostedBy()) && Objects.equals(getTweet(), tweets.getTweet()) && Objects.equals(getStatus(), tweets.getStatus()) && Objects.equals(getCreatedAt(), tweets.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostedBy(), getTweet(), getStatus(), getCreatedAt());
    }
}