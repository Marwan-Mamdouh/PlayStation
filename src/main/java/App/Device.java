package App;

/*
 Device id should be from 100 to 120 and can not have any
 characters or symbols just positive integers from 100 to 120
*/
public record Device(int deviceId,
                     boolean isFree,
                     EDevice deviceType,
                     Integer assignTo) {

  Device(int deviceId, EDevice deviceType) {
    this(deviceId, true, deviceType, null);
  }

  /*
    // instance variables
    private int deviceId;
    private boolean isFree = true;
    private EDevice deviceType;
    private Integer assignTo = null;

    Device(EDevice deviceType) {
        this()
        this.deviceType = deviceType;
    }

    Device(int deviceId) {
        this(deviceId, EDevice.PS4);
    }

    public Device(int deviceId, boolean isFree, EDevice deviceType, Integer assignTo) {
        this.deviceId = deviceId;
        this.isFree = isFree;
        this.deviceType = deviceType;
        this.assignTo = assignTo;
    }

    @Override
    public boolean getIsFree() {
        return isFree;
    }

    @Override
    public int getDeviceId() {
        return deviceId;
    }

    @Override
    public int getAssignTo() {
        return assignTo;
    }

    @Override
    public EDevice getDeviceType() {
        return deviceType;
    }

    @Override
    public String toString() {
        return "Device{ device ID : " + deviceId +
                ", device type: " + deviceType +
                (assignTo == null? ", not assigned"
                        : ", assign to:" + assignTo) + " }\n";
    }
*/
}
