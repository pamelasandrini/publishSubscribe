package com.sprint.eai.designpattern.bo;

public class Message {

	private long id;
	private long subscriberId;
	private String message;
	private boolean read;

	public Message() {
		super();
	}

	public Message(long id, long subscriberId, String message, boolean read) {
		super();
		this.id = id;
		this.subscriberId = subscriberId;
		this.message = message;
		this.read = read;
	}

	public Message(long subscriberId, String message, boolean read) {
		super();
		this.subscriberId = subscriberId;
		this.message = message;
		this.read = read;
	}

	public long getSubscriberId() {
		return subscriberId;
	}

	public void setSubscriberId(long subscriberId) {
		this.subscriberId = subscriberId;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isRead() {
		return read;
	}

	public void setRead(boolean read) {
		this.read = read;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
