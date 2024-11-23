package App;

public interface IDevice {

    //
    boolean getIsFree();

    // produce the deviceId id
    int getDeviceId();

    // produce the deviceId type
    EDevice getDeviceType();

    // produce where this deviceId is used
    int getAssignTo();

    // assign the deviceId to some IAssignable,
    // make it unavailable to use.
    void assignTo(int assignTo);

    // make the init deviceId free to use again
    void releaseDevice();
}
