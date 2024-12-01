package App;

import java.util.ArrayList;

public class Room extends AAssignable implements IAssignable {

    // instance variables
    private int roomId;

    // static variables
//    private static ArrayList<Room> rooms = new ArrayList<>();

    Room() {}

    // full constrictor
    Room(int roomId, boolean isFree,Integer deviceId) {
        this.roomId = roomId;
        this.isFree = isFree;
        this.deviceId = deviceId;
//        this.deviceId.assignTo(this.roomId);
//        rooms.add(this);
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
        return "Room{ roomId=" + roomId +
                ", deviceId=" + deviceId +
                ", isFree=" + isFree + " }";
    }

//    // produce an array List from empty rooms
//    public static ArrayList<Room> getAvailableRooms() {
//        ArrayList<Room> freeRooms = new ArrayList<>();
//        for (Room room: rooms) {
//            if (room.getIsFree()) {
//                freeRooms.add(room);
//            }
//        }
//        return freeRooms;
//    }
}
