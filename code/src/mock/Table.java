package mock;

import java.util.*;

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
   *          - the name of the table.
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
   *          - the name of the attribtue associated with the value.
   * @param value
   *          - the value to save under that attribtue.
   * @return true if the value has been added to the attribute.
   */
  public boolean add(String attributename, String value) {
    boolean result = false;

    if (getTable().get(attributename) != null) {
      result = getTable().get(attributename).add(value);
    } else {
      getTable().put(attributename, new ArrayList());
      result = getTable().get(attributename).add(value);
    }
    return result;
  }

  /**
   * Get the values of a specified attribute.
   *
   * @param attribute
   *          - The name of the attribute.
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

  public String toString() {
    StringBuilder s = new StringBuilder();

    this.table.forEach((k, v) -> {
      StringBuilder b = new StringBuilder();
      v.forEach(a -> {
        b.append(a + ", ");
      });
      s.append("Attribute - " + k + ": " + b.toString() + "\n");
    });

    return s.toString();
  }

  public TableIterator iterator() {
    return new TableIterator(this);
  }
}
