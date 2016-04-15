package mock;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * A wrapper of a Map to represent a database.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Database {
  private List<Table> tables;
  private String name;

  /**
   * Default constructor.
   */
  public Database() {
    this.tables = new ArrayList<Table>();
  }

  /**
   * Create a database with a name.
   * 
   * @param name
   *          the name of the database.
   */
  public Database(String name) {
    this.tables = new ArrayList<Table>();
    this.name = name;
  }

  /**
   * Get the database.
   * 
   * @return the database.
   */
  public List<Table> getTables() {
    return this.tables;
  }

  /**
   * ∫ Get the Table with the specified table name;
   * 
   * @param tablename
   *          the name of the table to attain.
   * @return the Table, or null if it can't find the table.
   */
  public Table getTable(String tablename) {
    for (int i = 0; i < this.tables.size(); i++) {
      if (this.tables.get(i).getName().equals(tablename)) {
        return this.tables.get(i);
      }
    }
    return null;
  }

  /**
   * Add a new Table to the array with the specified name.
   * 
   * @param name
   *          the name of the table to create.
   * @return true if the table has been added or not.
   */
  public boolean createTable(String name) {
    return this.tables.add(new Table(name));
  }

  /**
   * Insert into the database.
   * 
   * @param statement
   *          the statement to be executed.
   * @return if the statement was executed successfully or not.
   */
  public boolean insert(String statement) {
    // insert (ops) into table name
    String table = statement.substring(statement.indexOf("o ") + 2, statement.indexOf("(") - 1);

    statement = statement.replace(table, "");

    String as = statement.substring(statement.indexOf("(") + 1, statement.indexOf(")"));
    statement = statement.replace("(" + as + ")", "");

    String ops = statement.substring(statement.indexOf("(") + 1, statement.indexOf(")"));
    ArrayList<String> attributes = new ArrayList<String>(Arrays.asList(as.split(", ")));
    ArrayList<String> values = new ArrayList<String>(Arrays.asList(ops.split(", ")));

    for (String a : attributes) {
      this.insert(table, a, values.get(attributes.indexOf(a)));
    }

    return true;
  }

  /**
   * Private insert into the the table.
   * 
   * @param table
   *          the table to be inserted into.
   * @param attribute
   *          which attribute it is inserted into.
   * @param value
   *          the value to be inserted.
   * @return if the insertion worked or not.
   */
  private boolean insert(String table, String attribute, String value) {
    return this.getTable(table).add(attribute, value);
  }

  /**
   * Remove from a database.
   * 
   * @param statement
   *          the statement to parse and execute.
   * @return if the statement was executed successfully.
   */
  public boolean delete(String statement) {
    String table = statement.substring(statement.indexOf("m ") + 2, statement.indexOf("w") - 1);
    String attribute = statement.substring(statement.indexOf("where ") + 6, statement.indexOf("="));
    String value = statement.substring(statement.indexOf("=") + 1, statement.length());

    this.getTable(table).delete(attribute, value);
    return true;

  }

  /**
   * Remove the table form the database.
   * 
   * @param tablename
   *          the name of the table to remove.
   * @return if the remove was successful.
   */
  public boolean drop(String tablename) {
    for (Table table : this.tables) {
      if (table.getName().equals(tablename)) {
        this.tables.remove(table);
        return true;
      }
    }
    return false;
  }

  /**
   * Get the name of the database.
   * 
   * @return the database's name.
   */
  public String getName() {
    return this.name;
  }
}
