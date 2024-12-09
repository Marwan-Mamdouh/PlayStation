package App;

public record Admin(String adminName, String adminPassword, int adminId) {

}

//    implements IAdmin
//{
//    private String adminName;
//    private String adminPassword;
//    private int adminId;
//
//    Admin (String name, String password) {
//        adminName = name;
//        adminPassword = password;
//    }
//
//    Admin(String name, String password,int adminId) {
//        adminName = name;
//        adminPassword = password;
//        this.adminId = adminId;
//    }
//
//    public int getAdminId() {
//        return adminId;
//    }
//
//    // produce the admin name (String)
//    public String getAdminName() {
//        return adminName;
//    }

/*
    public void setAdminId(int adminId) {
        this.adminId = adminId;
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
    public void startSession(int adminId, int AssignableId) {
        new Session(adminId, AssignableId);
    }
    @Override
    public double endSession(Session session) {
        return session.endAndCharge();
    }
*/
//}
