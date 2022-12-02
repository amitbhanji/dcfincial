package com.dcfin.idp.tests;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.dcfin.idp.connectionpool.BasicConnectionPool;
import com.dcfin.idp.connectionpool.ConnectionPool;
import com.dcfin.idp.dao.RoleDao;
import com.dcfin.idp.model.Role;

class RoleDaoUnitTest {
    private RoleDao dao;
    private static ConnectionPool connectionPool;

    @BeforeEach
    void setup() throws SQLException, ClassNotFoundException {
    	 connectionPool = BasicConnectionPool.create("jdbc:mysql://localhost:3306/dcfinancial?serverTimezone=UTC"
         		, "root", "admin");
        Connection connection = connectionPool.getConnection();
        dao = new RoleDao(connection);
    }

    @Test
    void whenInsertAPerson_thenItNeverThrowsAnException() {
        assertDoesNotThrow(() -> dao.insert(new Role("batchadmin","Batch Admin", null)));
    }

    @Test
    void whenInsertARoleWithQuoteInText_thenItNeverThrowsAnException() {
        assertDoesNotThrow(() -> dao.insert(new Role("batch'sadmin","Batch Admin", null)));
    }

    /*@Test
    void whenGetAPersonById_thenItReturnThePersonInDatabase() throws SQLException {
        dao.insert(new Role("batchadmin","Batch Admin", null));

        Optional<PersonEntity> maybeEmployee = dao.getById(1);
        assertTrue(maybeEmployee.isPresent());

        PersonEntity personEntity = maybeEmployee.get();

        assertEquals(1, personEntity.getId());
        assertEquals("john", personEntity.getName());
    }*/

    /*@Test
    void whenInsertAndGetMultipleRoles_thenItNeverThrowsAnException() throws SQLException {
        assertDoesNotThrow(() -> dao.insert(
            Arrays.asList(new Role("batchadmin1","Batch Admin 1", null), new Role("batchadmin2","Batch Admin 2", null))));

        List<Role> result = dao.getAll();

        assertEquals(Arrays.asList(new Role("batchadmin1","Batch Admin 1", null), new Role("batchadmin2","Batch Admin 2", null)),
            result);
    }*/

    /*@Test
    void whenUpdateAnExistentPerson_thenItReturnsTheUpdatedPerson() throws SQLException {
        dao.insert(new Role("batchadmin1","Batch Admin 1", null));
        dao.update(new Role("batchadmin1","Batch Admin 1", null));

        Optional<PersonEntity> maybePerson = dao.getById(1);

        assertTrue(maybePerson.isPresent());

        PersonEntity personEntity = maybePerson.get();

        assertEquals(1, personEntity.getId());
        assertEquals("johnny", personEntity.getName());
    }*/

    /*@Test
    void whenDeleteAPersonById_thenItWillBeAbsentInDatabase() throws SQLException {
        dao.insert(new PersonEntity(1, "john"));
        dao.deleteById(1);

        Optional<PersonEntity> maybePerson = dao.getById(1);

        assertFalse(maybePerson.isPresent());
    }*/

    /*@Test
    void whenAHackerUpdateAPerson_thenItUpdatesTheTargetPerson() throws SQLException {
        dao.insert(Arrays.asList(new PersonEntity(1, "john"), new PersonEntity(2, "skeet")));
        dao.update(new PersonEntity(1, "hacker' --"));

        List<PersonEntity> result = dao.getAll();

        assertEquals(Arrays.asList(new PersonEntity(1, "hacker' --"), new PersonEntity(2, "skeet")),
            result);
    }*/
}