package java.sql;

import java.util.Map;

import mock.Table;
import mock.TableIterator;

/**
 * Mocking the java.sql.ResultSet class. This mock implementation is essentially a generic iterator
 * for any potential queries to the mock Database or Table class.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class ResultSet {
  private Table table;
  private TableIterator iterator;
  private Map<String, String> current;

  public ResultSet() {
    System.out.println("ResultSet");
  }

  public ResultSet(Table table) {
    this.iterator = table.iterator();

    System.out.println("ResultSet Table: " + table);
  }

  public String getString(String string) {
    System.out.println("Getting string with key: " + string);
    return this.current.get(string);
  }

  public int getInt(String string) {
    System.out.println("Getting int with key: " + string);
    return Integer.parseInt(this.current.get(string));
  }

  public boolean next() {
    if (this.iterator.hasNext()) {
      this.current = this.iterator.next();
      return true;
    }
    return false;
  }

  public void close() {
    System.out.println("Closing ResultSet...");
  }
}
