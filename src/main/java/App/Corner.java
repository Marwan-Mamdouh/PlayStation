package App;

import java.util.ArrayList;

public class Corner extends AAssignable implements IAssignable {

    // instance variables
    private int cornerId;

    // static variables
//    private static ArrayList<Corner> corners = new ArrayList<>();

    Corner() {}

    Corner(int cornerId, boolean isFree, Integer deviceId) {
        this.cornerId = cornerId;
        this.isFree = isFree;
        this.deviceId = deviceId;
//        this.deviceId.assignTo(this.cornerId);
//        corners.add(this);
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
                ", is free?: " + isFree +
                ", deviceId type: " + deviceId + " }\n";
    }

//    public static ArrayList<Corner> getAvailableDevices() {
//        ArrayList<Corner> freeDevices = new ArrayList<>();
//        for (Corner corner: corners) {
//            if (corner.getIsFree()) {
//                freeDevices.add(corner);
//            }
//        }
//        return freeDevices;
//    }
}

