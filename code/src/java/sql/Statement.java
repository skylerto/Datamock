package java.sql;

import java.util.List;

import mock.Database;
import mock.Table;

/**
 * The object used for executing a static SQL statement and returning the results it produces.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Statement {

  /*
   * The DATABASE is a "Map<String, Map<String, List<String\>\>\>" of TABLE names -> a Map<String,
   * List <String>>, a TABLE is Map<String, List<String>> -> ATTRIBUTE name, an ATTRIBUTE has a list
   * of VALUES where its index is the ROW #/ID #.
   */
  private Database database;

  public Statement() {
    System.out.println("Statement");
    this.database = new Database(DriverManager.database);
  }

  /**
   * Execute the specified Query command.
   * 
   * @param input
   *          the desired query.
   * @return an iterator over the query results.
   */
  public ResultSet executeQuery(String input) {
    System.out.println("Executing Query: " + input);
    int index = input.indexOf("from ") + 4;

    String tablename = input.substring(index, input.length()).trim();
    List<Table> tables = this.database.getTables();

    return new ResultSet(this.database.getTable(tablename));
  }

  /**
   * Execute the specified command from the passed input.
   * 
   * @param input
   *          the input command and arguments.
   * @return if the command hits
   */
  public boolean execute(String input) {
    // Parse input
    String[] parse = input.split(" ");
    String command = parse[0]; // e.g. create, drop
    String instance = parse[1]; // e.g. table, databse column...
    String tablename = parse[2];
    System.out.println("TABLENAME: " + tablename);

    // Look for command in the string

    // IF it's a create table, create a new map, add it to the map at the
    // table name.

    switch (command) {
    case "create":
      if (instance.equals("table")) {
        this.database.createTable(tablename);
        // Who even cares about schema atm.
      }
      System.out.println("Creating table... " + tablename);
      break;
    case "drop":

      System.out.println("Dropping table... " + tablename);
      break;
    default:
      break;
    }

    System.out.println("Executing: " + input);
    return true;
  }

  /**
   * Execute update an update statement such as insert into.
   * 
   * @param input
   *          the update to execute.
   * @return always 1.
   */
  public int executeUpdate(String input) {
    // Parse input
    String[] parse = input.split(" ");
    String command = parse[0]; // e.g. create, drop
    String instance = parse[1]; // e.g. table, database column...
    String tablename = parse[2];
    System.out.println(command);
    // Look for command in the string

    // IF it's a create table, create a new map, add it to the map at the
    // table name.

    switch (command) {
    case "insert":
      this.database.insert(input);
      String scheme = input.substring(input.indexOf("(") + 1, input.indexOf(")"));
      String values = input.substring(input.lastIndexOf("(") + 1, input.lastIndexOf(")"));

      System.out.println("Scheme: " + scheme + " Values: " + values);

      // Who even cares about schema atm.

      System.out.println("Creating table... " + tablename);
      break;
    case "drop":
      // if (instance.equals("table") && this.database.containsKey(tablename)) {
      // this.database.remove(tablename);
      // }
      System.out.println("Dropping table... " + tablename);
      break;
    default:
      break;
    }

    System.out.println("executeUpdate: " + input);

    return 1;
  }

  public void close() {
    System.out.println("Closing Statement...");
  }
}
