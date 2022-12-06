package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Optional;

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
		connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC",
				"root", "admin");
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

	@Test
	void whenDeleteARoleById() throws SQLException {
		Group group = new Group("admingroup", null);
		group.setGroupId(1);

		dao.deleteById(group);
	}

	@Test
	void whenGetARoleById_thenItReturnTheRoleInDatabase() throws SQLException {
		// Role role1 = new Role("batchadmin2", "batchadmin", null);
		dao.insert(new Group("batchadmin", null));
		Optional<Group> group = dao.getById(13);
		// assertTrue(role.isPresent());
		Group newgroup = group.get();
		System.out.println(newgroup.getGroupId());
		System.out.println(newgroup.getGroupDescription());
		// assertEquals("developer3",newrole.getRoleName());

	}

	@Test
	void whenUpdateAnExistentPerson_thenItReturnsTheUpdatedPerson() throws SQLException {
		// dao.insert(new Role("batchadmin1","Batch Admin 1", null));
		dao.update(3, new Group("Admin1", null));

	}
}
