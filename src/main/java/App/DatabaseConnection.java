package App;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public enum DatabaseConnection {

  INSTANCE; // The single instance
  private final Connection connection;

  DatabaseConnection() {
    try {
      String url = "jdbc:sqlite:/home/marwanmamdouh/java labs/Playstation/src/main/"
          + "resources/database/Play.db";
      connection = DriverManager.getConnection(url);
    } catch (SQLException e) {
      throw new RuntimeException("Error connecting to the database", e);
    }
  }

  public Connection getConnection() {
    return connection;
  }
}
