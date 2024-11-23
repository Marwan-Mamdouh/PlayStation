package App;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DeviceTest {

    IDevice d1 = new Device(100);
    IDevice d2 = new Device(101, EDevice.PS4);
    IDevice d3 = new Device(102, EDevice.PS5);

    IAssignable ia1 = new Room(21, true, 100);
    IAssignable ia2 = new Corner(22, true, 101);
    IAssignable ia3 = new Corner(23, true, 102);

    @Test
    void deviceShouldBeFreeAlready(){
        var d10 = new Device(15, EDevice.PS5);
        assertTrue(d10.getIsFree());
    }

    @Test
    void deviceIdShouldBeFrom10To100() {
        assertTrue(d1.getDeviceId() >= 10 && d1.getDeviceId() < 100);
        assertTrue(d2.getDeviceId() >= 10 && d2.getDeviceId() < 100);
        assertTrue(d3.getDeviceId() >= 10 && d3.getDeviceId() < 100);
    }

    @Test
    void getDeviceId() {
        assertEquals(10, d1.getDeviceId());
        assertEquals(11, d2.getDeviceId());
        assertEquals(12, d3.getDeviceId());

        assertNotEquals(99.23, d1.getDeviceId());
        assertNotEquals(1, d2.getDeviceId());
        assertNotEquals(-23, d3.getDeviceId());
    }

    @Test
    void getAssignTo() {
        assertEquals(102, d3.getAssignTo());
        assertEquals(101, d2.getAssignTo());
        assertEquals(100, d1.getAssignTo());

        assertNotEquals(ia2, d1.getAssignTo());
        assertNotEquals(ia3, d3.getAssignTo());
        assertNotEquals(ia1, d2.getAssignTo());
    }

    @Test
    void getDeviceType() {
        assertEquals(EDevice.PS4,d1.getDeviceType());
        assertEquals(EDevice.PS4,d2.getDeviceType());
        assertEquals(EDevice.PS5,d3.getDeviceType());

        assertNotEquals(EDevice.PS5,d1.getDeviceType());
        assertNotEquals(EDevice.PS5,d2.getDeviceType());
        assertNotEquals(EDevice.PS4,d3.getDeviceType());
    }

    @Test
    void assignTo() {
        IDevice testDevice = new Device(13);
        IAssignable testAssignable = new Corner(103, true, 13);
        assertFalse(testDevice.getIsFree());
        assertEquals(13, testDevice.getAssignTo());
    }

    @Test
    void releaseDevice() {
        d1.releaseDevice();
        assertTrue(d1.getIsFree());
        assertNull(d1.getAssignTo());
    }

    @Test
    void testToString() {
        assertEquals(d1.toString(),
                "Device{ deviceId Id: " + d1.getDeviceId() +
                        ", deviceId type: " + d1.getDeviceType() +
                        ", assign to: " + d1.getAssignTo() + " }"
        );
    }
}