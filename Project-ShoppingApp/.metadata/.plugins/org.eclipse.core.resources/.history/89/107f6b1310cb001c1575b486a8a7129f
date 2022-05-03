package sql.testcase;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

import sql.DatabaseConnection;

class TestDatabaseConnection {

	@Test
	void testGetConnection() {
		Connection result = DatabaseConnection.getConnection();
		assertEquals(result!=null,true);
	}

}
