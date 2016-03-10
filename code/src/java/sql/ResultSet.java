package java.sql;

public class ResultSet {
  public ResultSet() {
    System.out.println("ResultSet");
  }

  public String getString(String s) {
    System.out.println("Getting string with key: " + s);
    return s;
  }

  public int getInt(String s) {
    System.out.println("Getting int with key: " + s);
    return 1;
  }

  public Boolean next(){
    return false;
  }

  public void close(){
    System.out.println("Closing ResultSet...");
  }
}
