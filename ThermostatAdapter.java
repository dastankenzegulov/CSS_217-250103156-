public class ThermostatAdapter implements SmartDevice {
    private final LegacyThermostat thermostat;

    public ThermostatAdapter(LegacyThermostat thermostat) {
        if (thermostat == null) {
            throw new IllegalArgumentException("Thermostat reference cannot be null");
        }
        this.thermostat = thermostat;
    }

    @Override
    public void turnOn() {
        String currentDial = thermostat.checkDial();
        if ("IDLE".equals(currentDial)) {
            thermostat.rotateDial("LOW");
        }
    }

    @Override
    public void turnOff() {
        thermostat.rotateDial("IDLE");
    }

    @Override
    public boolean isOn() {
        String state = thermostat.checkDial();
        if (state == null) return false;

        return switch (state) {
            case "LOW", "MEDIUM", "MAX" -> true;
            default -> false;
        };
    }

    @Override
    public int getPowerPercent() {
        String state = thermostat.checkDial();
        if (state == null) return -1;

        return switch (state) {
            case "IDLE" -> 0;
            case "LOW" -> 33;
            case "MEDIUM" -> 66;
            case "MAX" -> 100;
            default -> -1;
        };
    }
}