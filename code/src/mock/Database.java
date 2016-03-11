package mock;

import java.util.*;

/**
 * A wrapper of a Map to represent a database.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Database {
  private Map<String, Table> database;

  public Database() {
    this.database = new HashMap<String, Table>();
  }

  /**
   * Get the database.
   * @return the database.
   */
  public Map<String, Table>getDatabase() {
    return this.database;
  }

  /**
   * Get the Table with the specified table name;
   * @param  tablename the name of the table to attain.
   * @return           the Table.
   */
  public Table getTable(String tablename) {
    return this.database.get(tablename);
  }
}
