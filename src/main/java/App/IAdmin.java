package App;

public interface IAdmin {

    // start bew session with the customer name.
    void startSession(int adminId, int assignableId);

    // end existing session and calc the cost.
//    double endSession(Session session);

    // produce the admin name that is currently logging.
    String getAdminName();

    int getAdminId();
}
