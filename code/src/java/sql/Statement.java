package java.sql;

import mock.Database;
import mock.Table;

/**
 * The object used for executing a static SQL statement and returning the results it produces.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Statement {

  private Database database;

  public Statement() {
    this.database = new Database(DriverManager.database);
  }

  /**
   * Execute the specified Query command.
   * 
   * @param input
   *          the desired query.
   * @return an iterator over the query results.
   * @throws SQLException
   *           if the table cannot be found.
   */
  public ResultSet executeQuery(String input) throws SQLException {
    int index = input.indexOf("from ") + 4;
    String tablename = input.substring(index, input.length()).trim();
    Table table = this.database.getTable(tablename);
    if (table != null) {
      return new ResultSet(table);
    } else {
      throw new SQLException(tablename);
    }

  }

  /**
   * Execute the specified command from the passed input.
   * 
   * @param input
   *          the input command and arguments.
   * @return if the command hits
   */
  public boolean execute(String input) {
    boolean result = false;

    // Parse input
    String[] parse = input.split(" ");
    String command = parse[0];
    String instance = parse[1];
    String tablename = parse[2];

    switch (command) {
    case "create":
      result = this.database.createTable(tablename.trim());
      break;
    case "drop":
      result = this.database.drop(tablename);
      break;
    default:
      result = false;
      break;
    }

    return result;
  }

  /**
   * Execute update an update statement such as insert into.
   * 
   * @param input
   *          the update to execute.
   * @return always 1.
   */
  public int executeUpdate(String input) {
    boolean result = false;

    // Parse input
    String[] parse = input.split(" ");
    String command = parse[0]; // e.g. create, drop
    String instance = parse[1]; // e.g. table, database column...
    String tablename = parse[2];
    switch (command) {
    case "insert":
      result = this.database.insert(input);
      break;
    case "delete":
      result = this.database.delete(input);
      break;
    case "drop":
      result = this.database.drop(tablename);
      break;
    default:
      break;
    }

    return result ? 1 : 0;
  }

  /**
   * Close the connection to the statement.
   */
  public void close() {

  }
}
