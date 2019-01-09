package com.sprint.eai.designpattern.broker;

import java.util.ArrayList;
import java.util.List;

import com.sprint.eai.designpattern.vo.Subscriber;

public class Broker {

	private List<Subscriber> initializeDefaultSubscribers() {

		List<Subscriber> defaultSuscribers = new ArrayList<>();

		Subscriber sub1 = new Subscriber("Mike", "dog");
		Subscriber sub2 = new Subscriber("Ellen", "cat");

		defaultSuscribers.add(sub1);
		defaultSuscribers.add(sub2);

		return defaultSuscribers;

	}

	public boolean sendMessage(String message) {

		boolean messageSent = false;

		List<Subscriber> defaultSuscribers = initializeDefaultSubscribers();

		for (Subscriber subscriber : defaultSuscribers) {

			if (message.contains(subscriber.getTopic())) {
				subscriber.setMessage(message);
				messageSent = true;
			}
		}

		return messageSent;
	}

	// get the message

	// knows the list of subscribers

	// decide which subscriber will receive the message

	// send the message
}
