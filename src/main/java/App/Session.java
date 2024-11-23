package App;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Session implements ISession {

    private String ctrName;
    private String startTime;
    private Integer assignableId;

    Session() {}

    // corner session constructor
    Session(String ctrName, int assignableId) {
        startTime = getCurrentTime();
        this.ctrName = ctrName;
        this.assignableId = assignableId;
//        this.assignableId = assignable;
//        this.assignableId.book();
    }

    public String getCurrentTime() {
        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Get the current time and format it
        return LocalDateTime.now().format(formatter);
    }


    // produce name of the customer who opened theis session
    public String getCtrName() {
        return ctrName;
    }

    @Override
    // calc time of the session till now
    public long calcDuration() {
        Duration duration = Duration.between(LocalDateTime.parse(startTime), LocalDateTime.now());
        return duration.toHours();
    }

//    @Override
//    // produce the cost of the session and end it
//    public double endAndCharge() {
//        assignableId.release();
//        return calcCost();
//    }

//    @Override
//    public double calcCost() {
//        long hoursPlayed = calcDuration();
//        // charge for PS4 and PS5
//        return switch (assignableId.getDeviceType()) {
//            case PS4 -> charge(hoursPlayed, EDevice.PS4.getChargeValue());
//            case PS5 -> charge(hoursPlayed, EDevice.PS5.getChargeValue());
//        };
//    }

    // charge by cost par hour depend on PS4 or PS5
//    private double charge(double hoursPlayed, int cost) {
//        return hoursPlayed * cost;
//    }

    @Override
    public String toString() {
        return "Session{ctrName: " + ctrName +
                ", assignableId: " + assignableId +
                ", start at: " + startTime +'}';
    }
}
