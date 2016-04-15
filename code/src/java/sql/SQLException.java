package java.sql;

/**
 * Mock SQLException.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class SQLException extends Throwable {
  private static final long serialVersionUID = -7807603756244048543L;

  public SQLException(String err) {
    super(err);
  }
}
