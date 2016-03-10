package java.sql;

public class DriverManager {
  public DriverManager(){
    System.out.println("DriverManager");
  }

  public static Connection getConnection(String s1, String s2, String s3){
    System.out.println("getting Connection: " + s1 + " " + s2+ " " + s3);
    return new Connection();
  }
}
