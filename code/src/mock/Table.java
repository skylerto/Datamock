package mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * A wrapper of a Map to represent a database table.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Table {
  // Map of Attribute Name -> List of values.
  private Map<String, List<String>> table;
  private String name;

  /**
   * Create an instance of a Table with the specified name.
   *
   * @param name
   *          the name of the table.
   */
  public Table(String name) {
    this.table = new HashMap<String, List<String>>();
    this.name = name;
  }

  /**
   * Get the table.
   * 
   * @return The table.
   */
  public Map<String, List<String>> getTable() {
    return this.table;
  }

  /**
   * Add a specified value of that attribtue.
   *
   * @param attributename
   *          the name of the attribtue associated with the value.
   * @param value
   *          the value to save under that attribtue.
   * @return true if the value has been added to the attribute.
   */
  public boolean add(String attributename, String value) {
    boolean result = false;

    if (getTable().get(attributename) != null) {
      result = getTable().get(attributename).add(value);
    } else {
      getTable().put(attributename, new ArrayList<String>());
      result = getTable().get(attributename).add(value);
    }
    return result;
  }

  /**
   * Remove row from the table where the attribute of that row is the value.
   * 
   * @param attribute
   *          the attribute to find the value.
   * @param value
   *          the value of the attribute.
   * @return if the remove worked.
   */
  public boolean delete(String attribute, String value) {
    boolean result = false;
    if (getTable().get(attribute) != null) {
      TableIterator tb = new TableIterator(this);
      while (tb.hasNext()) {
        Map<String, String> row = tb.next();
        for (Entry<String, String> entry : row.entrySet()) {
          if (entry.getKey().equals(attribute) && entry.getValue().equals(value)) {
            result = tb.delete();
          }
        }
      }
    }
    return result;
  }

  /**
   * Get the values of a specified attribute.
   *
   * @param attribute
   *          The name of the attribute.
   * @return a list of all the values for that attribute.
   */
  public List<String> getValues(String attribute) {
    return this.table.get(attribute);
  }

  public String getName() {
    return this.name;
  }

  /**
   * Returns a String Set of all the attributes in the table.
   * 
   * @return a Set of table attributes.
   */
  public Set<String> getAttribtues() {
    return this.table.keySet();
  }

  /**
   * Return a string representation of the table.
   */
  public String toString() {
    StringBuilder str = new StringBuilder();

    this.table.forEach((key, value) -> {
      StringBuilder otherStr = new StringBuilder();
      value.forEach(a -> {
        otherStr.append(a + ", ");
      });
      str.append("Attribute - " + key + ": " + otherStr.toString() + "\n");
    });

    return str.toString();
  }

  /**
   * Return a new table iterator.
   * 
   * @return a new {@link TableIterator}.
   */
  public TableIterator iterator() {
    return new TableIterator(this);
  }
}
