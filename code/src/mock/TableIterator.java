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

  private int index; // index in the attribute array
  private Table table;

  public TableIterator(Table table) {
    this.index = 0;
    this.table = table;
  }

  @Override
  public boolean hasNext() {
    return index < table.getAttribtues().size();
  }

  @Override
  public Map<String, String> next() {
    Map<String, String> val = new HashMap();
    for (Entry<String, List<String>> entry : table.getTable().entrySet()) {
      val.put(entry.getKey(), entry.getValue().get(index));
    }
    incrementIndex();
    return val;
  }

  private void incrementIndex() {
    this.index++;
  }

}
