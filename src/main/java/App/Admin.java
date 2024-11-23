package App;

import java.util.Map;

public class Admin implements IAdmin {

    private final String adminName;
    private final String adminPassword;

    Admin (String name, String password) {
        adminName = name;
        adminPassword = password;
    }

    public static Admin login(Map<String, Admin> adminMap,
                              String username,
                              String password) {
        Admin admin = adminMap.get(username);
        if (admin != null && admin.adminPassword.equals(password)) {
            System.out.println("Admin " + username + " login successfully.");
            return admin;
        }
        else {
            System.out.println("Username or password are Invalid.");
            return null;
        }
    }

    @Override
    // produce the admin name (String)
    public String getAdminName() {
        return adminName;
    }

    @Override
    public Session startSession(int iAssignable,
                                String ctrName) {
        return new Session(ctrName, iAssignable);
    }

//    @Override
//    public double endSession(Session session) {
//        return session.endAndCharge();
//    }
}
