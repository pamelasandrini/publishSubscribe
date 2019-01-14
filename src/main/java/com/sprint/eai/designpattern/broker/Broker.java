package com.sprint.eai.designpattern.broker;

import java.util.ArrayList;
import java.util.List;

import com.sprint.eai.designpattern.vo.Message;
import com.sprint.eai.designpattern.vo.Subscriber;
import com.sprint.eai.designpattern.vo.Topic;

public class Broker {

	private List<Subscriber> initializeDefaultSubscribers() {

		List<Subscriber> defaultSuscribers = new ArrayList<>();

		Subscriber sub1 = new Subscriber("Mike", Topic.Android);
		Subscriber sub2 = new Subscriber("Ellen", Topic.Iphone);

		defaultSuscribers.add(sub1);
		defaultSuscribers.add(sub2);

		return defaultSuscribers;

	}

	public boolean sendMessage(Message message) {

		boolean messageSent = false;

		List<Subscriber> defaultSuscribers = initializeDefaultSubscribers();

		for (Subscriber subscriber : defaultSuscribers) {

			if (message.getTopic().equals(subscriber.getTopic().name())) {
				subscriber.setMessage(message.getText());
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
