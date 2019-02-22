package com.sprint.eai.designpattern.broker;

import java.util.ArrayList;
import java.util.List;

import com.sprint.eai.designpattern.bo.Message;
import com.sprint.eai.designpattern.bo.Subscriber;

public class Broker {

	public boolean sendMessage(Message message) {

		boolean messageSent = false;

		//call Subscriber service
		List<Subscriber> subscribers = new ArrayList<>(); 

		for (Subscriber subscriber : subscribers) {

			if (message.getTopic().equals(subscriber.getTopic())) {
				subscriber.addMessage(message.getText());
				messageSent = true;
			}
		}

		return messageSent;
	}

}
