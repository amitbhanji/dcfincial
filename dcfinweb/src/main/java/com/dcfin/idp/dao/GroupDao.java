package com.dcfin.idp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dcfin.idp.model.Group;

public class GroupDao {

	private final Connection connection;

	public GroupDao(Connection connection) {
		this.connection = connection;
	}

	public Optional<Group> getById(int groupId) throws SQLException {
		String query = "SELECT \n" + "    idp_group_description,\n" + "    idp_group_createdate\n"
				+ "    FROM dcfinancial.idp_group where idp_group_id = ?";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, groupId);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.first()) {
			Group result = new Group(resultSet.getString("idp_group_description"),
					resultSet.getString("idp_group_createdate"));
			return Optional.of(result);
		} else {
			return Optional.empty();
		}
	}

	public void insert(Group group) throws SQLException {

		String query = "INSERT INTO dcfinancial.idp_group\n" + "(idp_group_description)\n" + "VALUES\n" + "(?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, group.getGroupDescription());
		preparedStatement.executeUpdate();
	}

	public void insert(List<Group> groups) throws SQLException {
		String query = "INSERT INTO dcfinancial.idp_group\n" + "(idp_group_description)\n" + "VALUES\n" + "(?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		for (Group group : groups) {
			preparedStatement.setString(1, group.getGroupDescription());
			preparedStatement.addBatch();
		}
		preparedStatement.executeBatch();
	}

	public void update(int groupId, Group group) throws SQLException {
		String query = "UPDATE dcfinancial.idp_group \n" + "SET \n" + "idp_group_description = ? \n"
				+ "WHERE idp_group_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, group.getGroupDescription());
		preparedStatement.setInt(2, groupId);
		preparedStatement.executeUpdate();
	}

	public void deleteById(Group group) throws SQLException {
		String query = "DELETE from dcfinancial.idp_group \n" + "WHERE idp_group_id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, group.getGroupId());
		preparedStatement.executeUpdate();

	}

	/*
	 * public void deleteById(int roleId) throws SQLException {
	 * 
	 * String query = "DELETE from dcfinancial.idp_role\n" +
	 * "WHERE idp_role_id = ?"; PreparedStatement preparedStatement =
	 * connection.prepareStatement(query); preparedStatement.setInt(1, roleId);
	 * preparedStatement.executeUpdate(); }
	 */
	public List<Group> getAll() throws SQLException {
		String query = "SELECT idp_group_description,idp_group_createdate FROM dcfinancial.idp_group";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		ResultSet resultSet = preparedStatement.executeQuery();
		List<Group> result = new ArrayList<>();
		while (resultSet.next()) {
			result.add(
					new Group(resultSet.getString("idp_role_description"), resultSet.getString("idp_role_createdate")));
		}
		return result;
	}
}
