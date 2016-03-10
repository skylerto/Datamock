package java.sql;

public class Statement {
  public Statement(){
    System.out.println("Statement");
  }

  public ResultSet executeQuery(String s) {
    System.out.println("Executing Query: " + s);
    return new ResultSet();
  }

  public Boolean execute(String s){
    System.out.println("Executing: " + s);
    return true;
  }

  public Boolean executeUpdate(String s){
    System.out.println("executeUpdate: " + s);
    return true;
  }

  public void close(){
    System.out.println("Closing Statement...");
  }
}
