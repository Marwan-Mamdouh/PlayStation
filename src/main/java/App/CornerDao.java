package App;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

public class CornerDao implements ICornerDao{
    private final Connection connection;

    public CornerDao(Connection connection) {
        this.connection = connection;
    }

    // add new corner to db
    @Override
    public void add(Corner corner) throws Exception {
        String sql = "INSERT INTO corner (cornerId, isFree, deviceId) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, corner.getId());
            stmt.setInt(2, convertBoolToInt(corner.getIsFree()));
            stmt.setInt(3, corner.getDeviceId());
            stmt.executeUpdate();
        }
    }

    // change the device that in the corner
    @Override
    public void changeDevice(Corner corner, int deviceId) throws Exception {
        String sql = "UPDATE corner SET deviceId = ? WHERE cornerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, deviceId);
            stmt.setInt(2, corner.getDeviceId());
            stmt.executeUpdate();
        }
    }

    // book the corner, make it unavailable to use
    public void bookCorner(Corner corner) throws Exception {
        String sql = "UPDATE corner SET isFree = ? WHERE cornerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 0);
            stmt.setInt(2, corner.getId());
            stmt.executeUpdate();
        }
    }

    public void releaseCorner(Corner corner) throws Exception {
        String sql = "UPDATE corner SET isFree = ? WHERE cornerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, 1);
            stmt.setInt(2, corner.getDeviceId());
            stmt.executeUpdate();
        }
    }

    @Override
    public void delete(int cornerId) throws Exception {
        String sql = "DELETE FROM corner WHERE cornerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cornerId);
            stmt.executeUpdate();
        }
    }

    @Override
    public Corner findById(int cornerId) throws Exception {
        String sql = "SELECT * FROM corner WHERE cornerId = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, cornerId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return mapResultSetToDevice(rs);
                }
            }
        }
        return null; // Device not found
    }

    @Override
    public List<IAssignable> findAll() throws Exception {
        String sql = "SELECT * FROM corner";
        List<IAssignable> devices = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                devices.add(mapResultSetToDevice(rs));
            }
        }
        return devices;
    }

    // Helper method to map ResultSet to Device object
    private Corner mapResultSetToDevice(ResultSet rs) throws SQLException {
        int cornerId = rs.getInt("cornerId");
        boolean isFree = convertIntToBool(rs.getInt("isFree"));
        Integer deviceId = rs.getObject("deviceId") != null ? rs.getInt("deviceId") : null; // Handle null

//        EDevice deviceType = EDevice.valueOf(rs.getString("deviceType")); // Assuming EDevice is an enum
        return new Corner(cornerId, isFree, deviceId);
    }

    private boolean convertIntToBool(int result) {
        return result == 1;
    }

    private int convertBoolToInt(boolean result) {
        return result? 1 : 0;
    }
}
