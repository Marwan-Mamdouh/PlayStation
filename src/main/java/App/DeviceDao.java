package App;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class DeviceDao implements IDeviceDao {
    private final Connection connection;

    // Constructor: Pass a database connection (e.g., from a Singleton)
    public DeviceDao(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void insert(Device device) throws Exception {
        String sql = "INSERT INTO device (isFree, deviceType) VALUES (?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 1);
            stmt.setString(2, device.getDeviceType().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public void update(Device device) throws Exception {
        String sql = "UPDATE device SET isFree = ?, deviceType = ?, assignTo = ? WHERE deviceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setBoolean(1, device.getIsFree());
            stmt.setString(2, device.getDeviceType().name());
            stmt.setObject(3, device.getAssignTo()); // Nullable column
            stmt.setInt(4, device.getDeviceId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int deviceId) throws Exception {
        String sql = "DELETE FROM device WHERE deviceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, deviceId);
            stmt.executeUpdate();
        }
    }

    @Override
    public Device findById(int deviceId) throws Exception {
        String sql = "SELECT * FROM device WHERE deviceId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, deviceId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDevice(rs);
                }
            }
        }
        return null; // Device not found
    }

    @Override
    public List<Device> findAll() throws Exception {
        String sql = "SELECT * FROM device";
        List<Device> devices = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                devices.add(mapResultSetToDevice(rs));
            }
        }
        return devices;
    }

    // Helper method to map ResultSet to Device object
    private Device mapResultSetToDevice(ResultSet rs) throws SQLException {
        int deviceId = rs.getInt("deviceId");
        boolean isFree = convertIntToBool(rs.getInt("isFree"));
        // Assuming EDevice is an enum
        EDevice deviceType = EDevice.valueOf(rs.getString("deviceType"));
        // Handle null
        Integer assignTo = rs.getObject("assignTo") != null ? rs.getInt("assignTo") : null;
        return new Device(deviceId, isFree, deviceType, assignTo);
    }

    private boolean convertIntToBool(int result) {
      return result == 1;
    }
}

