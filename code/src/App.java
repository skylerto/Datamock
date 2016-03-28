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
    String username = "root";
    String password = "";

    try {
      Class.forName("com.mysql.jdbc.Driver").newInstance();

      con = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database + "?useSSL=false",
          username, password);

      stmt = con.createStatement();

      // Create table.
      stmt.execute("drop table if exists students");
      stmt.execute("create table students (name VARCHAR(20), id INT, PRIMARY KEY (id))");

      // Insert Data.
      stmt.executeUpdate("insert into students (name, id) values ('Skyler Layne', 212166906)");
      stmt.executeUpdate("insert into students (name, id) values ('John Doe', 212166907)");
      stmt.executeUpdate("insert into students (name, id) values ('Jane Smith', 212166908)");

      // Retrieve Data
      ResultSet rs = stmt.executeQuery("select * from students");
      while (rs.next()) {
        System.out.println(rs.getString("name") + ", " + rs.getInt("id"));
      }

      // Shut it down.
      rs.close();
      stmt.close();
      con.close();

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException
        | SQLException e) {
      e.printStackTrace();
    }
  }
}
