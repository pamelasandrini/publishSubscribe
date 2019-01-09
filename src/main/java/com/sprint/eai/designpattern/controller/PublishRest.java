package com.sprint.eai.designpattern.controller;

import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sprint.eai.designpattern.broker.Broker;

public class PublishRest {

	private Broker messageBroker = new Broker();

	@RequestMapping("publish")
	public String publish(@RequestAttribute String message) {

		// send the message to the broker

		boolean messageSent = messageBroker.sendMessage(message);

		return messageSent ? "success" : "error";
	}
}
