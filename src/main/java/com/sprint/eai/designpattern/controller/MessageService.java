package com.sprint.eai.designpattern.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.eai.designpattern.bo.Message;
import com.sprint.eai.designpattern.dao.MessageDAO;
import com.sprint.eai.designpattern.dao.MessageDAOImpl;

@RestController
@RequestMapping("/message")
public class MessageService {

	private MessageDAO messageDao = new MessageDAOImpl();

	@GetMapping("/{subscriberId}")
	public List<Message> getAllMessagesById(@PathVariable("subscriberId") long subscriberId) {

		return messageDao.getAllMessagesById(subscriberId);
	}

	@GetMapping("/all")
	public List<Message> getAllMessages() {

		return messageDao.getAllMessages();
	}
}
