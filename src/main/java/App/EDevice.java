package App;

public enum EDevice {
    PS4(25), // charge ps4 by 25 EGP
    PS5(35); // charge ps5 by 35 EGP

    private final int chargeValue;

    // Constructor to set the charge value for each deviceId type.
    EDevice(int chargeValue) {
        this.chargeValue = chargeValue;
    }

    // Getter method to retrieve the charge value.
    public int getChargeValue() {
        return chargeValue;
    }
}
