package App;


import at.favre.lib.crypto.bcrypt.BCrypt;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDao implements IAdminDao {

  private final Connection connection;

  public AdminDao(Connection connection) {
    this.connection = connection;
  }

  public void addAdmin(String name, String password) throws SQLException {
    String hashedPassword = BCrypt.withDefaults().hashToString(12, password.toCharArray());
    String sql = "INSERT INTO admins (username, password) VALUES (?, ?)";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setString(1, name);
      stat.setString(2, hashedPassword);
      stat.executeUpdate();
    }
  }

  public boolean verifyAdmin(String name, String password) throws SQLException {
    String sql = "SELECT password FROM admins WHERE username = ?";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setString(1, name);
      ResultSet rs = stat.executeQuery();
      if (rs.isBeforeFirst()) {
        BCrypt.Result result = BCrypt.verifyer().verify(password.toCharArray(),
            rs.getString("password"));
        return result.verified;
      }
      return false;
    }
  }

  public void deleteAdmin(String name, String password) throws SQLException {
    if (verifyAdmin(name, password)) {
      String sql = "DELETE FROM admins WHERE username = ?";
      try (PreparedStatement stat = connection.prepareStatement(sql)) {
        stat.setString(1, name);
        stat.executeUpdate();
      }
    }
  }
}
