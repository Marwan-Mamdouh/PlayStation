package App;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class AssignableDao implements IAssignableDao {

private final Connection connection;

public AssignableDao(Connection connection) {
  this.connection = connection;
  }

    // add a new room to db
    @Override
    public void add(IAssignable assignable) throws Exception {
      String tableName = String.valueOf(assignable.getClass()).toLowerCase().split("\\.")[1];
      String sql = "INSERT INTO " + tableName + "(isFree, deviceId) VALUES (?, ?)";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
        stmt.setInt(1, 1); // 1 for true, 0 for false
        stmt.setInt(2, assignable.getDeviceId());
        stmt.executeUpdate();
      }
    }

    // change the device that in the space
    @Override
    public void changeDevice(IAssignable assignable, int deviceId) throws Exception {
      String tableName = String.valueOf(assignable.getClass()).toLowerCase().split("\\.")[1];
      String sql = "UPDATE " + tableName + "SET deviceId = ? WHERE roomId = ?";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setInt(1, deviceId);
          stmt.setInt(2, assignable.getDeviceId());
          stmt.executeUpdate();
      }
    }

    // book the corner, make it unavailable to use
    public void book(IAssignable assignable) throws Exception {
      String tableName = String.valueOf(assignable.getClass()).toLowerCase().split("\\.")[1];
      String sql = "UPDATE " + tableName + " SET isFree = ? WHERE roomId = ?";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setInt(1, 0);
          stmt.setInt(2, assignable.getId());
          stmt.executeUpdate();
      }
    }

    public void release(IAssignable assignable) throws Exception {
      String tableName = String.valueOf(assignable.getClass()).toLowerCase().split("\\.")[1];
      String sql = "UPDATE " + tableName + " SET isFree = ? WHERE roomId = ?";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setInt(1, 1);
          stmt.setInt(2, assignable.getDeviceId());
          stmt.executeUpdate();
      }
    }

    @Override
    public void delete(int assignableId, String tableName) throws Exception {
      String sql = "DELETE FROM " + tableName + " WHERE roomId = ?";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setInt(1, assignableId);
          stmt.executeUpdate();
      }
    }

    @Override
    public IAssignable findById(int assignableId, String tableName) throws Exception {
      String sql = "SELECT * FROM " + tableName + " WHERE roomId = ?";
      try (PreparedStatement stmt = connection.prepareStatement(sql)) {
          stmt.setInt(1, assignableId
          );
          try (ResultSet rs = stmt.executeQuery()) {
              if (rs.next()) {
                  return mapResultSetToDevice(rs, tableName);
              }
          }
      }
      return null; // Device not found
    }

    @Override
    public List<IAssignable> findAll(String tableName) throws Exception {
      String sql = "SELECT * FROM " + tableName;
      List<IAssignable> devices = new ArrayList<>();
      try (PreparedStatement stmt = connection.prepareStatement(sql);
          ResultSet rs = stmt.executeQuery()) {
        while (rs.next()) {
          devices.add(mapResultSetToDevice(rs, tableName));
        }
      }
      return devices;
    }

    // Helper method to map ResultSet to Device object
    private IAssignable mapResultSetToDevice(ResultSet rs, String tableName) throws SQLException {
      int assignableId = rs.getInt(tableName + "Id");
      boolean isFree = convertIntToBool(rs.getInt("isFree"));
      Integer deviceId = rs.getObject("deviceId") != null ? rs.getInt("deviceId") : null;
      // Handle null

      // Assuming EDevice is an enum
//        EDevice deviceType = EDevice.valueOf(rs.getString("deviceType"));
      return switch (tableName) {
        case "room" -> new Room(assignableId, isFree, deviceId);
        case "corner" -> new Corner(assignableId, isFree, deviceId);
        default -> throw new IllegalStateException("Unexpected value: " + tableName);
      };
    }

    private boolean convertIntToBool(int result) {
      return result == 1;
    }

    private int convertBoolToInt(boolean result) {
      return result? 1 : 0;
    }
}