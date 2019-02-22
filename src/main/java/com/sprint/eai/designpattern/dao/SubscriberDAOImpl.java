package com.sprint.eai.designpattern.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.dbutils.DbUtils;

import com.sprint.eai.designpattern.bo.Subscriber;

public class SubscriberDAOImpl implements SubscriberDAO {

	@Override
	public long createSubscriber(Subscriber subscriber) {

		String sql = "INSERT INTO SUBSCRIBER (NAME, TOPIC) VALUES (? , ?)";

		System.out.println("calling createSubscriber");
		ResultSet generatedKeys = null;

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setString(1, subscriber.getName());
			stmt.setString(2, subscriber.getTopic());

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

			System.out.println("exception in getAccountById - " + e);
			return -1;
		} finally {
			DbUtils.closeQuietly(generatedKeys);
		}
	}

	@Override
	public Subscriber getSubscriberById(long id) {

		String sql = "SELECT NAME, TOPIC FROM SUBSCRIBER WHERE ID = ?";
		Subscriber sub = null;

		System.out.println("calling getSubscriberById : " + id);

		try (Connection conn = ConnectionFactory.getConnection(); PreparedStatement stmt = conn.prepareStatement(sql)) {

			stmt.setLong(1, id);

			try (ResultSet rs = stmt.executeQuery()) {

				if (rs.next()) {

					String name = rs.getString("NAME");
					String topic = rs.getString("TOPIC");

					sub = new Subscriber(name, topic);
					sub.setId(id);
				}
			}

			return sub;

		} catch (SQLException e) {

			System.out.println("exception in getSubscriberById - " + e);
			return null;
		}

	}

	@Override
	public List<Subscriber> getAllSubscribers() {

		String sql = "SELECT ID, NAME, TOPIC FROM SUBSCRIBER";
		List<Subscriber> subscriberList = new ArrayList<>();

		System.out.println("calling getAllSubscribers ");

		try (Connection conn = ConnectionFactory.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {

			while (rs.next()) {

				long id = rs.getLong("ID");
				String name = rs.getString("NAME");
				String topic = rs.getString("TOPIC");

				Subscriber subscriber = new Subscriber(id, name, topic);
				subscriberList.add(subscriber);
			}

			return subscriberList;

		} catch (SQLException e) {

			System.out.println("exception in getAllSubscribers - " + e);
			return Collections.emptyList();
		}

	}

}
