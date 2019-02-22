package com.sprint.eai.designpattern.broker;

import java.util.List;

import com.sprint.eai.designpattern.bo.Message;
import com.sprint.eai.designpattern.bo.Subscriber;
import com.sprint.eai.designpattern.dao.MessageDAO;
import com.sprint.eai.designpattern.dao.MessageDAOImpl;
import com.sprint.eai.designpattern.dao.SubscriberDAO;
import com.sprint.eai.designpattern.dao.SubscriberDAOImpl;

public class Broker {

	//TODO: change to autowired
	private MessageDAO messageDao = new MessageDAOImpl();
	private SubscriberDAO subscriberDAO = new SubscriberDAOImpl();

	public boolean sendMessage(String topic, String text) {

		boolean messageSent = false;

		// TODO: check if need to change to Subscriber service
		List<Subscriber> subscribers = subscriberDAO.getAllSubscribers();

		for (Subscriber subscriber : subscribers) {

			if (topic.equals(subscriber.getTopic())) {

				Message message = new Message(subscriber.getId(), text, false);
				messageDao.createMessage(message);
				messageSent = true;
			}
		}

		return messageSent;
	}

}
