package App;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;

public class SessionDao implements ISessionDao {

  private final Connection connection;

  // Constructor: Pass a database connection (e.g., from a Singleton)
  SessionDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void startSession(Session session) throws SQLException {
    String sql = "INSERT INTO session (adminId, roomId) VALUES (?, ?)";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, session.getAdminId());
      stat.setInt(2, session.getAssignableId());
      stat.executeUpdate();
    }
  }

  @Override
  public Session getSessionById(int sessionId) throws SQLException {
    String sql = "SELECT * FORM session  WHERE sessionId = ?";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, sessionId);
      try (ResultSet rs = stat.executeQuery()) {
        if (rs.next()) {
          return mapRSToSession(rs);
        }
      }
      return null;
    }
  }

  @Override
  public List<Session> getAllSessions() throws SQLException {
    String sql = "SELECT * FROM sessions";
    List<Session> sessions = new ArrayList<>();
    try (PreparedStatement stat = connection.prepareStatement(sql);
    ResultSet rs = stat.executeQuery()) {
      while(rs.next()){
        sessions.add(mapRSToSession(rs));
      }
    }
    return sessions;
  }

  @Override
  public void endSession(int sessionId) throws SQLException {
    String sql = "UPDATE sessions SET endTime = datetime('now') WHERE session_id = ?";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, sessionId);
      stat.executeUpdate();
    }
  }

//  SQLException@Override
//  public void deleteSession(int sessionId) throws SQLException {
//
//  }

  private Session mapRSToSession(ResultSet rs) throws SQLException {
    if (rs.next()) {
      return new Session(
          rs.getInt("session_id"),
          rs.getInt("assignable_id"),
          rs.getString("start_time"),
          rs.getString("end_time"),
          rs.getString("duration"));
    }
    return null;
  }
}
