package java.sql;

import java.util.*;

/**
 * The object used for executing a static SQL statement and returning the
 *results it produces.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Statement {

  /**
   * The DATABASE is a Map<String, Map<String, List<String>>> of TABLE names -> a Map<String, List<String>>, a TABLE is Map<String, List<String>> -> ATTRIBUTE name, an ATTRIBUTE has a list of VALUES where its index is the ROW #/ID #.
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

  public Boolean execute(String s) {
    // Parse s

    // Look for command in the string

    String command = null;
    // IF it's a create table, create a new map, add it to the map at the table name.

    switch (command) {
      case "create table":
        String tablename = null;
        this.database.put(tablename, new HashMap<>());
        // look over ops
        // (name VARCHAR(20), id INT, PRIMARY KEY (id))

        System.out.println("Create table...");
        break;
      default:
        break;
    }

    System.out.println("Executing: " + s);
    return true;
  }

  public Map<String, List<String>> getTable(String tablename){
    return this.database.get(tablename);
  }

  public Boolean executeUpdate(String s) {
    System.out.println("executeUpdate: " + s);
    return true;
  }

  public void close() {
    System.out.println("Closing Statement...");
  }
}
