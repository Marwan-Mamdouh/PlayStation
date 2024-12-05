package App;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Connection;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.List;
import java.util.Objects;

public class SessionDao implements ISessionDao {

  private final Connection connection;

  // Constructor: Pass a database connection (e.g., from a Singleton)
  SessionDao(Connection connection) {
    this.connection = connection;
  }

  @Override
  public void startRoomSession(Session session) throws SQLException {
    String sql = "INSERT INTO sessions (adminId, roomId) VALUES (?, ?)";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, session.getAdminId());
      stat.setInt(2, session.getAssignableId());
      stat.executeUpdate();
    }
  }

  @Override
  public void startCornerSession(Session session) throws SQLException {
    String sql = "INSERT INTO sessions (adminId, cornerId) VALUES (?, ?)";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, session.getAdminId());
      stat.setInt(2, session.getAssignableId());
      stat.executeUpdate();
    }
  }

  @Override
  public void endSession(int sessionId) throws SQLException {
    String sql = "UPDATE sessions SET endTime = datetime('now') WHERE session_id = ?";
    try (PreparedStatement stat = connection.prepareStatement(sql)) {
      stat.setInt(1, sessionId);
      stat.executeUpdate();
    }
  }

  @Override
  public Session getSessionById(int sessionId) throws SQLException {
    String sql = "SELECT * FROM sessions WHERE sessionId = ?";
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
    String sql = "SELECT sessionId, roomId, cornerId, startTime, endTime, duration FROM sessions";
    List<Session> sessions = new ArrayList<>();
    try (PreparedStatement stat = connection.prepareStatement(sql);
    ResultSet rs = stat.executeQuery()) {
      while(rs.next()) {
        sessions.add(mapRSToSession(rs));
      }
    }
    return sessions;
  }

  private Session mapRSToSession(ResultSet rs) throws SQLException {
    if (rs.next()) {
//      Object roomId = rs.getObject("roomId");
//      return roomId == null?
          return new Session(rs.getInt("sessionId"),
              rs.getInt("cornerId"),
              rs.getString("startTime"),
              rs.getString("endTime"),
              rs.getString("duration"));
//          :new Session(rs.getInt("sessionId"),
//              rs.getInt("roomId"),
//              rs.getString("startTime"),
//              rs.getString("endTime"),
//              rs.getString("duration"));
    }
    else
      return null;
  }

//  SQLException@Override
//  public void deleteSession(int sessionId) throws SQLException {
//
//  }
}
