package com.example.paginationdemo.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;
@Data
public class TweetsDto {

    public TweetsDto() {
        this.createdAt = Instant.now();
    }

    public TweetsDto(String postedBy, String tweet, String status) {
        this.postedBy = postedBy;
        this.tweet = tweet;
        this.status = status;
        this.createdAt = Instant.now();
    }

    private Long id;

    private String postedBy;

    private String tweet;

    private String status;

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
        if (!(o instanceof TweetsDto)) return false;
        TweetsDto tweets = (TweetsDto) o;
        return Objects.equals(getId(), tweets.getId()) && Objects.equals(getPostedBy(), tweets.getPostedBy()) && Objects.equals(getTweet(), tweets.getTweet()) && Objects.equals(getStatus(), tweets.getStatus()) && Objects.equals(getCreatedAt(), tweets.getCreatedAt());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getPostedBy(), getTweet(), getStatus(), getCreatedAt());
    }
}