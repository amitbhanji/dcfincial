package com.dcfin.idp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.dcfin.idp.model.Role;

public class RoleDao {

    private final Connection connection;

    public RoleDao(Connection connection) {
        this.connection = connection;
    }

    public Optional<Role> getById(int roleId) throws SQLException {
        String query = "SELECT \n"
        		+ "    idp_role_name,\n"
        		+ "    idp_role_description,\n"
        		+ "    idp_role_createdate\n"
        		+ "    FROM dcfinancial.idp_role where idp_role_id = ?";
        
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, roleId);
        ResultSet resultSet = preparedStatement.executeQuery();

        if (resultSet.first()) {
            Role result = new Role(resultSet.getString("idp_role_name"),
            						resultSet.getString("idp_role_description"),
            						resultSet.getString("idp_role_createdate"));
            return Optional.of(result);
        } else {
            return Optional.empty();
        }
    }

    public void insert(Role role) throws SQLException {

        String query = "INSERT INTO dcfinancial.idp_role\n"
        		+ "(idp_role_name,\n"
        		+ "idp_role_description)\n"
        		+ "VALUES\n"
        		+ "(?,\n"
        		+ "?);";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, role.getRoleName());
        preparedStatement.setString(2, role.getRoleDescription());
        preparedStatement.executeUpdate();
    }

    public void insert(List<Role> roles) throws SQLException {
        String query = "INSERT INTO dcfinancial.idp_role\n"
        		+ "(idp_role_name,\n"
        		+ "idp_role_description)\n"
        		+ "VALUES\n"
        		+ "(?,\n"
        		+ "?);";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        for (Role role : roles) {
            preparedStatement.setString(1, role.getRoleName());
            preparedStatement.setString(2, role.getRoleDescription());
            preparedStatement.addBatch();
        }
        preparedStatement.executeBatch();
    }

    public void update(int roleId,Role role) throws SQLException {
        String query = "UPDATE dcfinancial.idp_role\n"
        		+ "SET\n"
        		+ "idp_role_name = ?,\n"
        		+ "idp_role_description = ? \n"
        		+ "WHERE idp_role_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, role.getRoleName());
        preparedStatement.setString(2, role.getRoleDescription());
       preparedStatement.setInt(3, roleId);
        preparedStatement.executeUpdate();
    }

    public void deleteById(int roleId) throws SQLException {
    	
        String query = "DELETE from dcfinancial.idp_role\n" 
        		+ "WHERE idp_role_id = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, roleId);
        preparedStatement.executeUpdate();
    }

    public List<Role> getAll() throws SQLException {
        String query = "SELECT idp_role_name, idp_role_description, idp_role_createdate FROM dcfinancial.idp_role";

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        ResultSet resultSet = preparedStatement.executeQuery();
        List<Role> result = new ArrayList<>();
        while (resultSet.next()) {
            result.add(new Role(resultSet.getString("idp_role_name"),
					resultSet.getString("idp_role_description"),
					resultSet.getString("idp_role_createdate")));
        }
        return result;
    }
}
