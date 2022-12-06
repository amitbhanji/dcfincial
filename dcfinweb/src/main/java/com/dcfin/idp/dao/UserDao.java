package com.dcfin.idp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import com.dcfin.idp.model.User;

public class UserDao {

	private final Connection connection;

	public UserDao(Connection connection)

	{
		this.connection = connection;
	}

	public Optional<User> getById(int userId) throws SQLException {
		String query = "SELECT \n" + " DCF_IDP_USER_UNAME,\n" + " DCF_IDP_USER_EMAIL,\n" + " DCF_IDP_USER_FNAME,\n"
				+ " DCF_IDP_USER_MNAME,\n" + " DCF_IDP_USER_LNAME,\n" + " DCF_IDP_USER_ADDRESS,\n"
				+ " DCF_IDP_USER_CREATE_TIME,\n" + " DCF_IDP_USER_CREATE_BY,\n" + " DCF_IDP_USER_UPDATE_TIME,\n"
				+ " DCF_IDP_USER_UPDATE_BY,\n" + " DCF_IDP_USER_DELETE_TIME,\n" + " DCF_IDP_USER_DELETE_BY,\n"
				+ " DCF_IDP_USER_IS_ACTIVE \n" + " FROM dcfinancial.idp_user where DCF_IDP_USER_ID = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userId);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.first()) {
			User result = new User(resultSet.getString("DCF_IDP_USER_UNAME"), resultSet.getString("DCF_IDP_USER_EMAIL"),
					resultSet.getString("DCF_IDP_USER_CREATE_TIME"));
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	public void insert(User user) throws SQLException {
		String query = "INSERT INTO dcfinancial.idp_user \n" + "(DCF_IDP_USER_UNAME,\n" + "DCF_IDP_USER_EMAIL)\n"
				+ "VALUES\n" + "(?,\n" + "?);";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUserUname());
		preparedStatement.setString(2, user.getUserEmail());
		preparedStatement.executeUpdate();
	}

	public void insert(List<User> users) throws SQLException {
		String query = "INSERT INTO dcfinancial.idp_user\n" + "(DCF_IDP_USER_UNAME,\n" + "DCF_IDP_USER_EMAIL)\n"
				+ "VALUES\n" + "(?,\n" + "?);";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (User user : users) {
			preparedStatement.setString(1, user.getUserUname());
			preparedStatement.setString(2, user.getUserEmail());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
	}

	public void update(int userId, User user) throws SQLException {
		String query = "UPDATE dcfinancial.idp_user\n" + "SET\n" + "DCF_IDP_USER_UNAME = ?,\n"
				+ "DCF_IDP_USER_EMAIL = ? \n" + "WHERE DCF_IDP_USER_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, user.getUserUname());
		preparedStatement.setString(2, user.getUserEmail());
		preparedStatement.setInt(3, userId);
		preparedStatement.executeUpdate();
	}

	public void deleteById(User user) throws SQLException {
		String query = "DELETE from dcfinancial.idp_user\n" + "WHERE DCF_IDP_USER_ID = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, user.getUserId());
		preparedStatement.executeUpdate();

	}

	public List<User> getAll() throws SQLException {
		String query = "SELECT DCF_IDP_USER_UNAME, DCF_IDP_USER_EMAIL,DCF_IDP_USER_CREATE_TIME FROM dcfinancial.idp_user";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<User> result = new ArrayList<>();
		while (resultSet.next()) {
			result.add(new User(resultSet.getString("DCF_IDP_USER_UNAME"),
					resultSet.getString("DCF_IDP_USER_CREATE_TIME"), resultSet.getString("DCF_IDP_USER_EMAIL")));

		}
		return result;
	}
}
