package App;

import java.sql.SQLException;

public interface IAdminDao {

  boolean verifyAdmin(String name, String password) throws SQLException;

  void addAdmin(String name, String password) throws SQLException;

  void deleteAdmin(String name, String password) throws SQLException;

}
