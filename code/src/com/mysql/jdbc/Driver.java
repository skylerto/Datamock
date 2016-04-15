package com.mysql.jdbc;

import java.sql.SQLException;

/**
 * A database driver emulator, by default we're using MySQL. For implementation of different style
 * of database such as MongoDB we would need to implement a new class structure.
 * 
 * @author Skyler Layne (c) All Rights Reserved.
 *
 */
public class Driver {
  public Driver() {
  }

  /**
   * We mock the checking of a valid database url. In practice it checks that the passed url is
   * valid for connection to the database.
   * 
   * @param url
   *          - a String representation of the url to connect to the databsse with.
   * @return - if the connection was successful.
   * @throws SQLException
   *           - pretend.
   */
  public boolean acceptsURL(String url) throws SQLException {
    return true;
  }

}
