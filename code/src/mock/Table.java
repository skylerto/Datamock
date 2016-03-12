package mock;

import java.util.*;

/**
 * A wrapper of a Map to represent a database table.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class Table {
  private Map<String, List<String>> table;
  private String name;

  public Table() {
    this.table = new HashMap<String, List<String>>();
    this.name = "";
  }

  public Table(String name) {
    this.table = new HashMap<String, List<String>>();
    this.name = name;
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
      result = getTable().get(attributename).add(value);
    }
    return result;
  }

  public String toString(){
    StringBuilder s = new StringBuilder();
    s.append("Table Name - " + this.name + "\n");

    this.table.forEach((k,v) -> {
      StringBuilder b = new StringBuilder();
      v.forEach(a -> {
        b.append(a + ", ");
      });
      s.append("Attribute - " + k + ": " + b.toString() + "\n");
    });

    return s.toString();
  }


}
