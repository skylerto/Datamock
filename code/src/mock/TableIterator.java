package mock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Iterator for a Table.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class TableIterator implements Iterator<Map<String, String>> {

  private int index;
  private Table table;

  /**
   * Create a new table Iterator with a table.
   * 
   * @param table
   *          - the table to iterator over.
   */
  public TableIterator(Table table) {
    this.index = 0;
    this.table = table;
  }

  /**
   * Check if there's another attribute in the table.
   * 
   * @return if there is a next item in the iterator.
   */
  @Override
  public boolean hasNext() {
    return index < table.getTable().size();
  }

  /**
   * Get the next column in the table.
   * 
   * @return the next table.
   */
  @Override
  public Map<String, String> next() {
    Map<String, String> val = new HashMap();
    for (Entry<String, List<String>> entry : table.getTable().entrySet()) {
      val.put(entry.getKey(), entry.getValue().get(index));
    }
    incrementIndex();
    return val;
  }

  /**
   * Delete the current row from the database.
   * 
   * @return if the delete worked.
   */
  public boolean delete() {
    boolean result = false;
    for (Entry<String, List<String>> entry : table.getTable().entrySet()) {
      List<String> anitem = entry.getValue();
      System.out.println(
          "AN ITEM: " + anitem.toString() + " item: " + anitem.get(index - 1) + " index: " + index);
      anitem.remove(index - 1);
      result = true;
    }
    return result;
  }

  /**
   * Move the iterator alone.
   */
  private void incrementIndex() {
    this.index++;
  }

}
