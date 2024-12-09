package App;

public class Room extends AAssignable implements IAssignable {

  // instance variables
  private int roomId;

  Room() {
  }

  // full constrictor
  Room(int roomId, boolean isFree, Integer deviceId) {
    this.roomId = roomId;
    this.isFree = isFree;
    this.deviceId = deviceId;
  }

  // assume every new room will be free to use in the creation moment
  Room(int roomId, int deviceId) {
    this(roomId, true, deviceId);
  }

  // for creating temp room to add to db
  Room(int deviceId) {
    isFree = true;
    this.deviceId = deviceId;
  }

  @Override
  // produce room id
  public int getId() {
    return roomId;
  }

  @Override
  // display the room info
  public String toString() {
    return "Room{ Room Id:" + roomId +
        ", device Id: " + deviceId +
        ", is free? " + isFree + " }\n";
  }
}