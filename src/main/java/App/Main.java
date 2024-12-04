package App;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

//        ISession session = new Session("ahmed", corner1);

//        System.out.println(d1);
//        System.out.println(corner1);
//        System.out.println(session);

        Connection connection = DatabaseConnection.getInstance().getConnection(); // From Singleton
        IDeviceDao deviceDao = new DeviceDao(connection);
        deviceDao.insert(new Device(EDevice.PS5));
        System.out.println(deviceDao.findAll());

        IAssignableDao assignableDao = new AssignableDao(connection);
//        assignableDao.add(new Room(110));
//        assignableDao.delete(26, "room");

    }
}