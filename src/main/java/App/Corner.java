package App;

public class Corner extends AAssignable implements IAssignable {

  // instance variables
  private int cornerId;

  // constrictor
  Corner() {
  }

  Corner(int cornerId, boolean isFree, Integer deviceId) {
    this.cornerId = cornerId;
    this.isFree = isFree;
    this.deviceId = deviceId;
  }

  Corner(int cornerId, int deviceId) {
    this(cornerId, true, deviceId);
  }

  Corner(int deviceId) {
    isFree = true;
    this.deviceId = deviceId;
  }

  @Override
  // produce the corner id
  public int getId() {
    return cornerId;
  }

  @Override
  // display the corner info
  public String toString() {
    return "Corner{ corner Id: " + cornerId +
        ", device Id: " + deviceId +
        ", is free? " + isFree +" }\n";
  }
}