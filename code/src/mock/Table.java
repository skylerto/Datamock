package mock;

import java.util.*;

/**
 * A wrapper of a Map to represent a database table.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Table {
  private Map<String, List<String>> table;

  public Table() {
    this.table = new HashMap<String, List<String>>();
  }

  public Map<String, List<String>> getTable() {
    return this.table;
  }

  public boolean add(String attributename, String value){
    boolean result = false;
    if(getTable().get(attributename) != null){
        result = getTable().get(attributename).add(value);
    } else {
      getTable().put(attributename, new ArrayList());
      result = getTable().containsKey(attributename);
    }
    return result;
  }


}
