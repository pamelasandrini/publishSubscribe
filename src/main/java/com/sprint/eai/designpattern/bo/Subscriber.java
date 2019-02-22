package com.sprint.eai.designpattern.bo;

import java.util.ArrayList;
import java.util.List;

public class Subscriber {

	private long id;

	private String name;

	private String topic;

	private List<String> messages = new ArrayList<>();

	public Subscriber() {

	}

	public Subscriber(String name, String topic) {

		this.name = name;
		this.topic = topic;
	}

	public Subscriber(long id, String name, String topic) {

		this.id = id;
		this.name = name;
		this.topic = topic;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public List<String> getMessages() {
		return messages;
	}

	public void addMessage(String message) {
		this.messages.add(message);
	}

}
