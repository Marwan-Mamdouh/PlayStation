package App;

abstract class AAssignable implements IAssignable {

    // instance variables
    int deviceId;
    boolean isFree;


    @Override
    // produce true if the room is free to use
    public boolean getIsFree() {
        return isFree;
    }

    @Override
    // produce the deviceId type
    public int getDeviceId() {
        return deviceId;
    }

    @Override
    // make variable isFree = true (the SPACE is not
    // free to use anymore till the next update)
    public void book() {
        isFree = false;
    }

    @Override
    // set isFree variable to false
    public void release() {
        isFree = true;
    }
}
