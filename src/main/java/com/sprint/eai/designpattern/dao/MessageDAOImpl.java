package com.sprint.eai.designpattern.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.sprint.eai.designpattern.bo.Message;

public class MessageDAOImpl implements MessageDAO {

	@Override
	public long createMessage(Message message) {

		String sql = "INSERT INTO MESSAGES (SUBSCRIBER_ID, MESSAGE, READ) VALUES (? ,? , ?)";

		System.out.println("calling createMessage");
		ResultSet generatedKeys = null;

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, message.getSubscriberId());
			stmt.setString(2, message.getMessage());
			stmt.setBoolean(3, message.isRead());

			int execRow = stmt.executeUpdate();

			if (execRow > 0) {
				generatedKeys = stmt.getGeneratedKeys();
				if (generatedKeys.next()) {
					// return the id
					return generatedKeys.getLong(1);
				}
			}

			return execRow;

		} catch (SQLException e) {

			System.out.println("exception in createMessage - " + e);
			return -1;
		} finally {
			DbUtils.closeQuietly(generatedKeys);
		}
	}

	@Override
	public List<Message> getAllMessages() {

		String sql = "SELECT ID, SUBSCRIBER_ID, MESSAGE, READ TOPIC FROM MESSAGES";
		List<Message> messageList = new ArrayList<>();

		System.out.println("calling getAllMessages ");

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {

				long id = rs.getLong("ID");
				long subscriberId = rs.getLong("SUBSCRIBER_ID");
				String message = rs.getString("MESSAGE");
				boolean read = rs.getBoolean("READ");

				messageList.add(new Message(id, subscriberId, message, read));
			}

			return messageList;

		} catch (SQLException e) {

			System.out.println("exception in getAllMessages - " + e);
			return Collections.emptyList();
		}

	}

	@Override
	public List<Message> getAllMessagesById(long subscriberId) {

		String sql = "SELECT ID, MESSAGE, READ FROM MESSAGES WHERE SUBSCRIBER_ID = ?";
		List<Message> messageList = new ArrayList<>();

		System.out.println("calling getAllMessagesById ");

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);) {
			
			stmt.setLong(1, subscriberId);

			try (ResultSet rs = stmt.executeQuery()) {

				while (rs.next()) {

					long id = rs.getLong("ID");
					String message = rs.getString("MESSAGE");
					boolean read = rs.getBoolean("READ");

					messageList.add(new Message(id, subscriberId, message, read));
				}
			}

			return messageList;

		} catch (SQLException e) {

			System.out.println("exception in getAllMessagesById - " + e);
			return Collections.emptyList();
		}

	}

}
