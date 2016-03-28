package java.sql;

import java.util.*;

/**
 * The object used for executing a static SQL statement and returning the
 * results it produces.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Statement {

	/**
	 * The DATABASE is a Map<String, Map<String, List<String>>> of TABLE names
	 * -> a Map<String, List<String>>, a TABLE is Map<String, List<String>> ->
	 * ATTRIBUTE name, an ATTRIBUTE has a list of VALUES where its index is the
	 * ROW #/ID #.
	 */
	private Map<String, Map<String, List<String>>> database;

	public Statement() {
		System.out.println("Statement");
		this.database = new HashMap<>();
	}

	public ResultSet executeQuery(String s) {
		System.out.println("Executing Query: " + s);
		return new ResultSet();
	}

	public boolean execute(String s) {
		// Parse s
		String[] parse = s.split(" ");
		String command = parse[0]; // e.g. create, drop
		String instance = parse[1]; // e.g. table, databse column...
		String tablename = parse[2];

		// Look for command in the string

		// IF it's a create table, create a new map, add it to the map at the
		// table name.

		switch (command) {
		case "create":
			if (instance.equals("table")) {
				this.database.put(tablename, new HashMap<>());
				// Who even cares about schema atm.
			}
			System.out.println("Creating table... " + tablename);
			break;
		case "drop":
			if (instance.equals("table") && this.database.containsKey(tablename)) {
				this.database.remove(tablename);
			}
			System.out.println("Dropping table... " + tablename);
			break;
		default:
			break;
		}

		System.out.println("Executing: " + s);
		return true;
	}

	public Map<String, List<String>> getTable(String tablename) {
		return this.database.get(tablename);
	}

	/**
	 * Execute update an update statement such as insert into.
	 */
	public int executeUpdate(String s) {
		System.out.println("executeUpdate: " + s);
		return 1;
	}

	public void close() {
		System.out.println("Closing Statement...");
	}
}
