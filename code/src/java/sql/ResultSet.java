package java.sql;

import mock.Table;
import mock.TableIterator;

import java.util.Map;

/**
 * Mocking the java.sql.ResultSet class. This mock implementation is essentially a generic iterator
 * for any potential queries to the mock Database or Table class.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class ResultSet {
  private TableIterator iterator;
  private Map<String, String> current;

  /**
   * Default Constructor.
   */
  public ResultSet() {
  }

  /**
   * Create a ResultSet with a specified {@link Table}.
   * 
   * @param table
   *          the table returning the result.
   */
  public ResultSet(Table table) {
    this.iterator = table.iterator();
  }

  /**
   * Get a String representation of the passed attribute.
   * 
   * @param attribute
   *          the attribute.
   * @return a string value of the current table row of the passed attribute.
   */
  public String getString(String attribute) {
    return this.current.get(attribute);
  }

  /**
   * Get an integer representation of the passed attribute.
   * 
   * @param attribute
   *          the attribute to query.
   * @return an int representation of the value of the given row column.
   */
  public int getInt(String attribute) {
    return Integer.parseInt(this.current.get(attribute.trim()));
  }

  /**
   * Move the TableIterator forward.
   * 
   * @return if we can move forward or not.
   */
  public boolean next() {
    if (this.iterator.hasNext()) {
      this.current = this.iterator.next();
      return true;
    }
    return false;
  }

  /**
   * Mock a closed connection.
   */
  public void close() {
  }
}
