package mockTests;

import org.junit.Test;
import static org.junit.Assert.*;
import mock.*;
import java.util.*;

/**
 * A Test class for testing the mock.Database class.
 *
 * @author Skyler Layne (c) All Rights Reserved.
 */
public class TableTest {
  @Test
  public void testCreate() {
    System.out.println("Running TABLE: testCreate -- ");
    Table t = new Table();

  }

  @Test
  public void testGet() {
    System.out.println("Running TABLE: testGet -- ");
    Table t = new Table();
    // assertEquals(new HashMap<String, Table>(), db.getDatabase());
  }

  @Test
  public void testGetTable() {
    System.out.println("Running TABLE testGetTable -- ");
    Table t = new Table();
    assertEquals(new HashMap<String, List<String>>(), t.getTable());
  }
  @Test
  public void testAdd() {
    System.out.println("Running TABLE testAddAttribute -- ");
    Table t = new Table("People");
    t.add("Name", "John");
    t.add("Name", "Jacob");
    t.add("Name", "Jingleheimer");
    t.add("Name", "Schmit");

    t.add("id", "2121");
    t.add("id", "2525");
    t.add("id", "4678");
    t.add("id", "9823");


    Map<String, List<String>> map = new HashMap<>();
    List<String> list = new ArrayList<>();
    list.add("John");
    list.add("Jacob");
    list.add("Jingleheimer");
    list.add("Schmit");

    List<String> list2 = new ArrayList<>();
    list2.add("2121");
    list2.add("2525");
    list2.add("4678");
    list2.add("9823");

    map.put("Name", list);
    map.put("id", list2);

System.out.println(t.toString());
    assertEquals(map, t.getTable());
  }

}
