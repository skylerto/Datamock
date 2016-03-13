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
    
    System.out.println(db.getTable("Employees"));

    assertEquals(new Table("Employees"), db.getTable("Employees"));

  }


}
