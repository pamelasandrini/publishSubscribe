package com.sprint.eai.designpattern.dao;

import java.util.List;

import com.sprint.eai.designpattern.bo.Message;

public interface MessageDAO {

	public long createMessage(Message message);

	public List<Message> getAllMessages();

	public List<Message> getAllMessagesById(long subscriberId);

}
