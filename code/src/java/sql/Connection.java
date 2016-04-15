package java.sql;

/**
 * Mock a database Connection object.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class Connection {
  public Connection() {
  }

  /**
   * Create a statement which will execute our queries for us.
   * 
   * @return a new {@link Statement} object.
   * @throws SQLException
   *           pretend.
   */
  public Statement createStatement() throws SQLException {
    return new Statement();
  }

  /**
   * Mock closing the connection to the database.
   */
  public void close() {
  }
}
