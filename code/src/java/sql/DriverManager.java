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

  public DriverManager() {
    System.out.println("DriverManager");
  }

  public static Connection getConnection(String s1, String s2, String s3) {
    url = s1;
    database = s1.substring(s1.lastIndexOf("/"), s1.indexOf("?"));
    System.out.println("getting Connection: " + s1 + " " + s2 + " " + s3);
    return new Connection();
  }
}
