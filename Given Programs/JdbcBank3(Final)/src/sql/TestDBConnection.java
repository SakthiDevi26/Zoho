package sql;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.Test;

class TestDBConnection {

	@Test
	void testGetConnection() {
		Connection result = DBConnection.getConnection();
		assertEquals(result!=null,true);
	}

}
