package com.sprint.eai.designpattern.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.eai.designpattern.bo.Subscriber;
import com.sprint.eai.designpattern.dao.SubscriberDAO;
import com.sprint.eai.designpattern.dao.SubscriberDAOImpl;

@RestController
@RequestMapping("/subscriber")
public class SubscriberService {

	// TODO: change to autowired
	private SubscriberDAO subscriberDao = new SubscriberDAOImpl();

	@PutMapping("/create")
	public long createSubscriber(Subscriber subscriber) {

		if (subscriber != null) {
			return subscriberDao.createSubscriber(subscriber);
		}

		return 0;
	}

	@GetMapping("/{id}")
	public Subscriber getSubscriber(@PathVariable("id") long id) {

		return subscriberDao.getSubscriberById(id);
	}

	@GetMapping("/all")
	public List<Subscriber> getAllSubscribers() {

		return subscriberDao.getAllSubscribers();
	}

}
