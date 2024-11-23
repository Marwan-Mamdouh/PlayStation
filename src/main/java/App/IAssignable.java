package App;

public interface IAssignable {

    // produce deviceId id.
    int getId();

    // produce true if the IAssignable is free to use.
    boolean getIsFree();

    // produce the deviceId type
    int getDeviceId();

    // change the variable isFree to true
    void book();

    // change the variable isFree to false
    void release();
}
