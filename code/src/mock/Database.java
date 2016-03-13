package mock;

import java.util.*;

/**
 * A wrapper of a Map to represent a database.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Database {
  private List<Table> tables;
  private String name;

  public Database(String name) {
    this.tables = new ArrayList<Table>();
    this.name = name;
  }

  /**
   * Get the database.
   * @return the database.
   */
  public List<Table> getTables() {
    return this.tables;
  }

  /**
   * Get the Table with the specified table name;
   * @param  tablename the name of the table to attain.
   * @return           the Table.
   */
  public Table getTable(String tablename) {
    Table t = this.tables.stream().filter(table -> table.getName().equals("tablename")).findFirst().get();

    return t;
  }

  public boolean createTable(String name){
      return this.tables.add(new Table(name));
  }
}
