package com.dcfin.idp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

import com.dcfin.idp.model.UserProfile;

public class UserProfileDao {

	private final Connection connection;

	public UserProfileDao(Connection connection)

	{
		this.connection = connection;

	}

	public Optional<UserProfile> getById(int userProfileId) throws SQLException {
		String query = "SELECT \n" + " idp_user_profile_description,\n" + " idp_user_profile_createdate \n"
				+ " FROM dcfinancial.idp_user_profile where idp_user_profile_id =? ";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, userProfileId);
		ResultSet resultSet = preparedStatement.executeQuery();

		if (resultSet.first()) {
			UserProfile result = new UserProfile(resultSet.getString("idp_user_profile_description"),
					resultSet.getString("idp_user_profile_createdate"));
			return Optional.of(result);

		} else {
			return Optional.empty();
		}
	}

	public void insert(UserProfile userprofile) throws SQLException {
		String query = "INSERT INTO dcfinancial.idp_user_profile \n" + "(idp_user_profile_description)\n" + "VALUES \n" + "(?);";

		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, userprofile.getUserProfileDescription());
		
		preparedStatement.executeUpdate();

	}

}
