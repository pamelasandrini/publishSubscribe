package com.sprint.eai.designpattern.dao;

import java.util.List;

import com.sprint.eai.designpattern.bo.Subscriber;

public interface SubscriberDAO {
	
	public long createSubscriber(Subscriber subscriber);
	
	public Subscriber getSubscriberById(long id);
	
	public List<Subscriber> getAllSubscribers();

}
