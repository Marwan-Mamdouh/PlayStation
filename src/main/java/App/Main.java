package App;


import java.sql.Connection;

public class Main {
    public static void main(String[] args) throws Exception {

//        IDevice d1 = new Device(1);
//        IDevice d2 = new Device(2);
//        IDevice d3 = new Device(3);
//        IDevice d4 = new Device(4, EDevice.PS4);
//        IDevice d5 = new Device(5, EDevice.PS4);
//        IDevice d6 = new Device(6, EDevice.PS5);
//        IDevice d7 = new Device(7, EDevice.PS5);
//        IDevice d8 = new Device(8, EDevice.PS5);
//        IDevice d9 = new Device(9, EDevice.PS5);
//        IDevice d10 = new Device(10, EDevice.PS5);
//
//        IAssignable corner1 = new Corner(25, d1);
//        IAssignable corner2 = new Corner(21, d2);
//        IAssignable corner3 = new Corner(22, d3);
//        IAssignable corner4 = new Corner(23, d4);
//        IAssignable corner5 = new Corner(24, d5);
//
//
//        IAssignable r1 = new Room(30, d6);
//        IAssignable r2 = new Room(31, d7);
//        IAssignable r3 = new Room(32, d8);
//        IAssignable r4 = new Room(33, d9);
//        IAssignable r5 = new Room(34, d10);

//        ISession session = new Session("ahmed", corner1);

//        System.out.println(d1);
//        System.out.println(corner1);
//        System.out.println(session);

        Connection connection = DatabaseConnection.getInstance().getConnection(); // From Singleton
//        IDeviceDao deviceDao = new DeviceDao(connection);
        ICornerDao cornerDao = new CornerDao(connection);

//        ICornerDao cornerDao1 = new CornerDao(connection);
//        Corner corner =  cornerDao1.findById(5);
        cornerDao.add(new Corner(6, true, 110));
//        cornerDao1.delete(5);
//        System.out.println(corner);

//        System.out.println(deviceDao.findAll());
//        System.out.println(cornerDao.findAll());
    }
}