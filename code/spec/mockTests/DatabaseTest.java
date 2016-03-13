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
public class DatabaseTest {
  @Test
  public void testCreate() {
    System.out.println("Running testCreate -- ");
    Database db = new Database("Store");
  }

  @Test
  public void testGet() {
    System.out.println("Running testGet -- ");
    Database db = new Database("Store");
    assertEquals(new ArrayList<Table>(), db.getTables());
  }

  @Test
  public void testGetTable() {
    System.out.println("Running testGetTable -- ");
    Database db = new Database("Store");
    assertEquals(null, db.getTable(""));
  }

  @Test
  public void testCreateTable() {
    System.out.println("Running testCreateTable -- ");
    Database db = new Database("Store");
    assertEquals(true, db.createTable("Employees"));
  }

  @Test
  public void testAddToTable() {
    System.out.println("Running testAddToTable -- ");
    Database db = new Database("Store");
    assertEquals(true, db.createTable("Employees"));
    db.insert("insert into Employees (name, id) VALUES (Skyler Layne, 212166906)");
  }
}
