package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

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
	void setup() throws SQLException, ClassNotFoundException {
		connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC",
				"root", "admin");
		Connection connection = connectionPool.getConnection();
		userdao = new UserDao(connection);

	}

	@Test
	void whenInsertAPerson_thenItNeverThrowsAnException() {
		assertDoesNotThrow(() -> userdao.insert(new User("amit", "amit@gmail.com", null)));
	}

	@Test
	void whenInsertARoleWithQuoteInText_thenItNeverThrowsAnException() {
		assertDoesNotThrow(() -> userdao.insert(new User("am'it", "amit@gmail.com", null)));
	}

	@Test
	void whenDeleteARoleById() throws SQLException {
		User user = new User("aboli", "batchadmin2", null);
		user.setUserId(9);
		userdao.deleteById(user);
	}

	@Test
	void whenGetARoleById_thenItReturnTheRoleInDatabase() throws SQLException {
		// Role role1 = new Role("batchadmin2", "batchadmin", null);
		userdao.insert(new User("batchadmin", "Batch Admin", null));
		Optional<User> user = userdao.getById(13);
		// assertTrue(role.isPresent());
		User newuser = user.get();
		System.out.println(newuser.getUserId());
		System.out.println(newuser.getUserUname());
		// assertEquals("developer3",newrole.getRoleName());

	}

	@Test
	void whenUpdateAnExistentPerson_thenItReturnsTheUpdatedPerson() throws SQLException {
		// dao.insert(new Role("batchadmin1","Batch Admin 1", null));
		userdao.update(4, new User("john", "john2@gmail.com", null));
	}
}