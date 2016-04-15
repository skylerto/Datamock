package mock;

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
    return index < this.table.getAttribtues().size();
  }

  /**
   * Get the next column in the table.
   * 
   * @return the next table.
   */
  @Override
  public Map<String, String> next() {
    Map<String, String> val = new HashMap<String, String>();
    for (Entry<String, List<String>> entry : table.getTable().entrySet()) {
      val.put(entry.getKey(), entry.getValue().get(this.index));
    }
    this.index++;
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
      anitem.remove(index - 1);
      result = true;
    }
    return result;
  }
}
