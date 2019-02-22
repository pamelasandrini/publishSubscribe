package com.sprint.eai.designpattern.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.eai.designpattern.bo.Subscriber;

@RestController("/subscriber")
public class SubscriberService {

	@PutMapping("/create")
	public String createSubscriber(Subscriber subscriber) {

		return null;
	}

	@GetMapping("/{id}")
	public String getSubscriber(int id) {

		return null;
	}

	@GetMapping("/all")
	public List<Subscriber> getAllSubscribers() {

		return null;
	}

}
