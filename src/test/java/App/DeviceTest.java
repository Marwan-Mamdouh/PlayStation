package App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

//    IDevice d1 = new Device(100);
    Device d2 = new Device(101, EDevice.PS4);
    Device d3 = new Device(102, EDevice.PS5);

    IAssignable ia1 = new Room(21, true, 101);
    IAssignable ia3 = new Corner(23, true, 102);

    @Test
    void deviceShouldBeFreeAlready(){
        var d10 = new Device(15, EDevice.PS5);
        assertTrue(d10.isFree());
    }

    @Test
    void deviceIdShouldBeFrom10To100() {
        assertTrue(d2.deviceId() >= 100 && d2.deviceId() < 120);
        assertTrue(d3.deviceId() >= 100 && d3.deviceId() < 120);
    }

    @Test
    void getDeviceId() {
        assertEquals(101, d2.deviceId());
        assertEquals(102, d3.deviceId());

        assertNotEquals(1, d2.deviceId());
        assertNotEquals(-23, d3.deviceId());
    }

    @Test
    void getAssignTo() {
      assertNull(d3.assignTo());
      assertNull(d2.assignTo());

      assertNotEquals(ia3.getDeviceId(), d3.assignTo());
      assertNotEquals(ia1.getDeviceId(), d2.assignTo());
    }

    @Test
    void getDeviceType() {
        assertEquals(EDevice.PS4,d2.deviceType());
        assertEquals(EDevice.PS5,d3.deviceType());

        assertNotEquals(EDevice.PS5,d2.deviceType());
        assertNotEquals(EDevice.PS4,d3.deviceType());
    }

    @Test
    void assignTo() {
        Device testDevice = new Device(102, EDevice.PS4);
        assertTrue(testDevice.isFree());;
    }
}