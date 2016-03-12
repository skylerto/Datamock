package mock;

import java.util.*;

/**
 * A wrapper of a Map to represent a database.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Database {
  private List<Table> database;
  private String name;

  public Database(String name) {
    this.database = new ArrayList<Table>();
    this.name = name;
  }

  /**
   * Get the database.
   * @return the database.
   */
  public List<Table> getDatabase() {
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

  public Boolean createTable(String name){
      Table t = this.database.put(name, new Table(name));
      return t == null ? false: true;
  }
}
