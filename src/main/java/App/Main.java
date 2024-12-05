package App;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

        Connection connection = DatabaseConnection.getInstance().getConnection(); // From Singleton
//        IDeviceDao deviceDao = new DeviceDao(connection);
//        deviceDao.insert(new Device(EDevice.PS5));
//        System.out.println(deviceDao.findAll());
//        IAssignableDao assignableDao = new AssignableDao(connection);

        ISessionDao sessionDao = new SessionDao(connection);
//        sessionDao.startRoomSession(new Session(4, 22));
//        sessionDao.startCornerSession(new Session(4, 1));
        System.out.println(sessionDao.getSessionById(4));
        System.out.println(sessionDao.getAllSessions());
//        ISession session = new Session(55,5);
    }
}