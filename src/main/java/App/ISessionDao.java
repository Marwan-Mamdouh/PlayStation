package App;

import java.util.List;
import java.sql.SQLException;

public interface ISessionDao {

  // Insert a new session
  void startSession(Session session) throws SQLException;

  // Retrieve a session by ID
  Session getSessionById(int sessionId) throws SQLException;

  // Retrieve all sessions
  List<Session> getAllSessions() throws SQLException;

  // Update a session's end time and duration
  void endSession(int sessionId) throws SQLException;

  // Delete a session by ID
//  void deleteSession(int sessionId) throws SQLException;
}
