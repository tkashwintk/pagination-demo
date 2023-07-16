package com.example.paginationdemo.repository;

import com.example.paginationdemo.model.Tweets;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TweetRepository extends PagingAndSortingRepository<Tweets, Long>, CrudRepository<Tweets, Long> {

    Page<Tweets> findPhoneByStatus(Pageable pageable, String status);

}