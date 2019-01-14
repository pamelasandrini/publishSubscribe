package com.sprint.eai.designpattern.vo;

public class Subscriber {

	private static int count = 0;

	private int id;

	private String name;

	private String messageRegex;

	private Topic topic;

	private String message;

	public Subscriber(String name, Topic topic) {

		this.name = name;
		this.topic = topic;
		count++;
		id = count;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessageRegex() {
		return messageRegex;
	}

	public void setMessageRegex(String messageRegex) {
		this.messageRegex = messageRegex;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Topic getTopic() {
		return topic;
	}

}
