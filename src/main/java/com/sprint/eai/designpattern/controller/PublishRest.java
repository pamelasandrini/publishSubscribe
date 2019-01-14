package com.sprint.eai.designpattern.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sprint.eai.designpattern.broker.Broker;
import com.sprint.eai.designpattern.vo.Message;

@RestController
@RequestMapping("/publish")
public class PublishRest {

	private Broker messageBroker = new Broker();

	@PostMapping("/publish")
	public String publish(@RequestParam(value = "message", required = true) String text,
			@RequestParam(value = "topic", required = true) String topic) {

		// send the message to the broker

		System.out.println("calling publish rest");
		System.out.println("topic: " + topic);
		System.out.println("text: " + text);

		Message message = new Message(topic, text);

		boolean messageSent = messageBroker.sendMessage(message);

		return messageSent ? "success" : "error";
	}
}
