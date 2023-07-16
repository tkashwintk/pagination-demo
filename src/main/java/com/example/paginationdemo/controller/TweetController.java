package com.example.paginationdemo.controller;

import com.example.paginationdemo.mapper.PageToPageDTOMapper;
import com.example.paginationdemo.model.PageDTO;
import com.example.paginationdemo.model.PageSettings;
import com.example.paginationdemo.model.Tweets;
import com.example.paginationdemo.model.TweetsDto;
import com.example.paginationdemo.service.TweetService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController()
@RequestMapping("/tweets")
public class TweetController {

    private TweetService tweetService;

    private PageToPageDTOMapper<Tweets> pageToPageDTOMapper;

    @Autowired
    public TweetController(TweetService tweetService, PageToPageDTOMapper<Tweets> pageToPageDTOMapper) {
        this.tweetService = tweetService;
        this.pageToPageDTOMapper = pageToPageDTOMapper;
    }

    @GetMapping("/tweet")
    public List<TweetsDto> getPlantPage(PageSettings pageSettings) {
        log.info("Request for tweets received with data : " + pageSettings);
        Page<Tweets> tweetsFromDB = tweetService.getTweets(pageSettings);
        return tweetsFromDB.stream().map(TweetController::apply).collect(Collectors.toList());
    }

    private static TweetsDto apply(Tweets tweet) {
        TweetsDto tweetsDto = new TweetsDto();
        tweetsDto.setId(tweet.getId());
        tweetsDto.setTweet(tweet.getTweet());
        tweetsDto.setPostedBy(tweet.getPostedBy());
        tweetsDto.setCreatedAt(tweet.getCreatedAt());
        tweetsDto.setStatus(tweet.getStatus());
        return tweetsDto;
    }
}