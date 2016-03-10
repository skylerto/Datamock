package java.sql;

public class Connection {
  public Connection(){
    System.out.println("Connection");
  }

  public Statement createStatement() throws SQLException {
    System.out.println("Creating a new statement!");
    return new Statement();
  }

  public void close(){
    System.out.println("Closing Connection...");
  }
}
