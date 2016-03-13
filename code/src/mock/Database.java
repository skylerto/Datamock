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

  public Database(String name)
  {
    this.tables = new ArrayList<Table>();
    this.name   = name;
  }

  /**
   * Get the database.
   * @return the database.
   */
  public List<Table>getTables()
  {
    return this.tables;
  }

  /**∫
   * Get the Table with the specified table name;
   * @param  tablename the name of the table to attain.
   * @return           the Table.
   */
  public Table getTable(String tablename)
  {
    for (int i = 0; i < this.tables.size(); i++) {
      if (this.tables.get(i).getName().equals(tablename)) {
        return this.tables.get(i);
      }
    }
    return null;
  }

  /**
   * Add a new Table to the array with the specified name.
   * @param  name the name of the table to create.
   * @return      true if the table has been added or not.
   */
  public boolean createTable(String name)
  {
    return this.tables.add(new Table(name));
  }

  public boolean insert(String statement) {
    // insert (ops) into table name
    String table = statement.substring(statement.indexOf(
                                         "o ") + 2, statement.indexOf("(") - 1);

    statement = statement.replace(table, "");

    String as = statement.substring(statement.indexOf(
                                              "(") + 1, statement.indexOf(")"));
    statement = statement.replace("(" + as + ")", "");

    String ops = statement.substring(statement.indexOf(
                                       "(") + 1, statement.indexOf(
                                       ")"));
    ArrayList<String> attributes =
      new ArrayList(Arrays.asList(as.split(", ")));
      ArrayList<String> values =
        new ArrayList(Arrays.asList(ops.split(", ")));

    System.out.println(attributes.toString() + ": " + values.toString());


    return true;
  }
}
