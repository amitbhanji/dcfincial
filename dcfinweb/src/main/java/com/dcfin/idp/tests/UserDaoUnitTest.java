package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;

import com.dcfin.idp.connectionpool.BasicConnectionPool;
import com.dcfin.idp.connectionpool.ConnectionPool;
import com.dcfin.idp.dao.UserDao;
import com.dcfin.idp.model.User;

 class UserDaoUnitTest {

	private UserDao userdao;
	private static ConnectionPool connectionPool;
	
	@BeforeEach
	void setup() throws SQLException,ClassNotFoundException
	{
		connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC", "root", "admin");
	    Connection connection = connectionPool.getConnection();
	    userdao = new UserDao(connection);
	
	}
	
	@Test
	void whenInsertAPerson_thenItNeverThrowsAnException()
	{
		assertDoesNotThrow(() -> userdao.insert(new User("amit","amit@gmail.com",null)));
	}
	@Test
	 void whenInsertARoleWithQuoteInText_thenItNeverThrowsAnException() {
	        assertDoesNotThrow(() -> userdao.insert(new User("am'it","amit@gmail.com", null)));
	    }

}
