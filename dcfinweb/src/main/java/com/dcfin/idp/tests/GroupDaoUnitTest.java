package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dcfin.idp.connectionpool.BasicConnectionPool;
import com.dcfin.idp.connectionpool.ConnectionPool;
import com.dcfin.idp.dao.GroupDao;

import com.dcfin.idp.model.Group;


public class GroupDaoUnitTest {

	
	 private GroupDao dao;
	 
	    private static ConnectionPool connectionPool;

	    @BeforeEach
	    void setup() throws SQLException, ClassNotFoundException {
	    	 connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC"
	         		, "root", "admin");
	        Connection connection = connectionPool.getConnection();
	        dao = new GroupDao(connection);
	    }

	    @Test
	    void whenInsertAPerson_thenItNeverThrowsAnException() {
	        assertDoesNotThrow(() -> dao.insert(new Group("Accounts", null)));
	    }
    @Test
	    void whenInsertARoleWithQuoteInText_thenItNeverThrowsAnException() {
	        assertDoesNotThrow(() -> dao.insert(new Group("Acc'ounts", null)));
	    }
}
