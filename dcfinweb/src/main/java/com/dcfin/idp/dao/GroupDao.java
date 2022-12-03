package com.dcfin.idp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.dcfin.idp.model.Group;


public class GroupDao {

	
	private final Connection connection;
	
	public GroupDao(Connection connection)
	{
		this.connection = connection;
	}
	
	public Optional<Group> getById(int groupId) throws SQLException {
        String query = "SELECT \n"
        		+ "    idp_group_description,\n"
        		+ "    idp_group_createdate\n"
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

        String query = "INSERT INTO dcfinancial.idp_group\n"
        		+ "(idp_group_description)\n"
        		+ "VALUES\n"
        		+ "(?)";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, group.getGroupDescription());
        preparedStatement.executeUpdate();
    }
}
