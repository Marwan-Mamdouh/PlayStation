package App;

public interface ISession {

    // produce customer name that is using the deviceId
    String getCtrName();

    // calc the duration of the session
    long calcDuration();

    // produce the cost of the session till now in case customer want to know it
//    double calcCost();

    // end the session and calc the cost of it
//    double endAndCharge();
}
