package java.sql;

/**
 * Mock DriverManager for connecting to database.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class DriverManager {
  public static String database;
  public static String url;

  /**
   * Default constructor.
   */
  public DriverManager() {
    System.out.println("DriverManager");
  }

  /**
   * Mock getting a connection to the Database.
   * 
   * @param url
   *          the url to connect to the database with.
   * @param user
   *          the user to connect to the database with.
   * @param password
   *          the password of the user.
   * @return a new {@link Connection} object.
   */
  public static Connection getConnection(String url, String user, String password) {
    database = url.substring(url.lastIndexOf("/"), url.indexOf("?"));
    System.out.println("getting Connection: " + url + " " + user + " " + password);
    return new Connection();
  }
}
