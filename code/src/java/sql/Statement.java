package java.sql;

/**
 * The object used for executing a static SQL statement and returning the
 *results it produces.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Statement {

  Map<String, G> database;
  public Statement() {
    System.out.println("Statement");
    database = new HashMap<>();
  }

  public ResultSet executeQuery(String s) {
    System.out.println("Executing Query: " + s);
    return new ResultSet();
  }

  public Boolean execute(String s) {
    System.out.println("Executing: " + s);
    return true;
  }

  public Boolean executeUpdate(String s) {
    System.out.println("executeUpdate: " + s);
    return true;
  }

  public void close() {
    System.out.println("Closing Statement...");
  }
}
