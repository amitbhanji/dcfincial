package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dcfin.idp.connectionpool.BasicConnectionPool;
import com.dcfin.idp.connectionpool.ConnectionPool;
import com.dcfin.idp.dao.UserProfileDao;
import com.dcfin.idp.model.Role;
import com.dcfin.idp.model.UserProfile;

public class UserProfileDaoUnitTest {

	private UserProfileDao dao;
	private static ConnectionPool connectionpool;
	
	@BeforeEach
	void setup()throws SQLException,ClassNotFoundException
	{
		connectionpool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC", "root", "admin");
	    Connection connection = connectionpool.getConnection();
	    dao = new  UserProfileDao(connection);
	}  
	    @Test
	    void whenInsertAPerson_thenItNeverThrowsAnException() {
	        assertDoesNotThrow(() -> dao.insert(new UserProfile("BatchAdmin", null)));
	    }

	    @Test
	    void whenInsertARoleWithQuoteInText_thenItNeverThrowsAnException() {
	        assertDoesNotThrow(() -> dao.insert(new UserProfile("Batc'hAdmin", null)));
	    }

	    
	    
	    
	
	
}
