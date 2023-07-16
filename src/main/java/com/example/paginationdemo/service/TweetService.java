package com.example.paginationdemo.service;

import com.example.paginationdemo.model.PageSettings;
import com.example.paginationdemo.model.Tweets;
import com.example.paginationdemo.repository.TweetRepository;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Service
public class TweetService {

    private TweetRepository tweetRepository;

    @Autowired
    public TweetService(
            TweetRepository tweetRepository) {
        this.tweetRepository = tweetRepository;
    }

    public Page<Tweets> getTweets(@NonNull PageSettings pageSetting) {

        Sort plantSort = pageSetting.buildSort();
        Pageable plantPage = PageRequest.of(pageSetting.getPage(), pageSetting.getElementPerPage(), plantSort);

        Page<Tweets> page = tweetRepository.findPhoneByStatus(plantPage,"new");

        page.getContent().stream().map(phone -> {
            phone.setStatus("read");
            return phone;
        }).forEach(phone -> tweetRepository.save(phone));

        System.out.println("Total: "+ page.getTotalElements());
        System.out.println("Page size: "+pageSetting.getElementPerPage());
        System.out.println("Has More: "+ (page.getTotalElements() > (long) pageSetting.getElementPerPage()));

        return page;
    }
}