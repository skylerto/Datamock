package com.mysql.jdbc;

import java.sql.SQLException;

public class Driver {
	public Driver() {
		System.out.println("Driver init");
	}

	boolean acceptsURL(String url) throws SQLException {
		return true;
	}

}
