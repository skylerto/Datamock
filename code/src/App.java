import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * A simple example of the usage of DataMock.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class App {

  /**
   * Main.
   * 
   * @param args
   *          - sys args.
   */
  public static void main(String[] args) {

    Connection con = null;
    Statement stmt;

    String database = "mission";
    String host = "localhost";
    String username = "mission_user";
    String password = "4315";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?useSSL=false",
          username, password);

      stmt = con.createStatement();

      /* Create table a table. */
      stmt.execute("drop table if exists students");
      stmt.execute("create table students (name VARCHAR(20), id INT, PRIMARY KEY (id))");

      /* Retrieve Data the data. */
      ResultSet rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getInt("id"));
      }

      /* Insert Data Into the Database. */
      System.out.println("Do some Inserting...");
      stmt.executeUpdate("insert into students (name, id) values ('Skyler Layne', 212166906)");
      stmt.executeUpdate("insert into students (name, id) values ('Jane Smith', 212166908)");
      stmt.executeUpdate("insert into students (name, id) values ('John Doe', 212166907)");

      /* Retrieve Data the data. */
      rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getInt("id"));
      }

      /* Remove from database. */
      System.out.println("Do a Delete...");
      stmt.executeUpdate("delete from students where name='Jane Smith'");
      stmt.executeUpdate("delete from students where name='Jane Smith'");

      /* Retrieve Data the data. */
      rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getInt("id"));
      }

      /* Drop table. */
      System.out.println("Do a Table Drop...");
      stmt.executeUpdate("drop table students");

      /* Retrieve Data the data, should throw an SQLException because we've deleted the table. */
      rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getInt("id"));
      }

      /* Shut it down. */
      rs.close();
      stmt.close();
      con.close();

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
        | SQLException e) {
      e.printStackTrace();
    }
  }
}
