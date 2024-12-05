package App;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Session implements ISession {

//    private String ctrName;
    private int sessionId;
    private int adminId;
    private int assignableId;
    private String startTime;
    private String endTime;
    private String duration;

    Session() {}

    // corner session constructor
    Session(int adminId,int assignableId) {
        this.adminId = adminId;
        this.assignableId = assignableId;
    }

    public Session(int sessionId, int assignableId,
        String startTime, String endTime, String duration) {
        this.sessionId = sessionId;
        this.assignableId = assignableId;
        this.startTime = startTime;
        this.endTime = endTime;
        this.duration = duration;
    }

    public String getCurrentTime() {
        // Define the format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        // Get the current time and format it
        return LocalDateTime.now().format(formatter);
    }


    // produce name of the customer who opened theis session
    public int getAdminId() {
        return adminId;
    }

    public int getAssignableId() {
        return assignableId;
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

//    @Override
//    public String toString() {
//        return "Session{ctrName: " + ctrName +
//                ", assignableId: " + assignableId +
//                ", start at: " + startTime +'}';
//    }

    @Override
    public String toString() {
        return "Session{" +
            "sessionId=" + sessionId +
//            ", adminId=" + adminId +
            ", assignableId=" + assignableId +
            ", startTime='" + startTime + '\'' +
            ", endTime='" + endTime + '\'' +
            ", duration='" + duration + '\'' +
            '}';
    }
}
