package java.sql;

/**
 * Mock SQLException.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class SQLException extends Throwable {
  public SQLException(String err) {
    super(err);
  }
}
