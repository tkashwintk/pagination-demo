package com.example.paginationdemo;

import com.example.paginationdemo.model.Tweets;
import com.example.paginationdemo.repository.TweetRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class MainApp {

	public static void main(String[] args) {
		SpringApplication.run(MainApp.class, args);
	}

	@Bean
	public ApplicationRunner run(TweetRepository tweetRepository) throws Exception {
		return (ApplicationArguments args) -> {
			List<Tweets> tweets = Arrays.asList(
					new Tweets("Jon", "Hi", "new"),
					new Tweets("Sam", "Hello", "new"),
					new Tweets("Jack", "Hai", "new"),
					new Tweets("Reacher", "Dear all", "new"),
					new Tweets("Joe", "Hello there!", "new"),
					new Tweets("Obi", "What's up", "new"),
					new Tweets("Ram", "Good morning", "new"),
					new Tweets("Lydia", "Good evening", "new"),
					new Tweets("Jose", "Good night", "new")
			);
			tweetRepository.saveAll(tweets);
		};

	}

}
