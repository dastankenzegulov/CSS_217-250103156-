public class BulbAdapter implements SmartDevice {
    private final LegacyBulb bulb;
    private static final int K = 6;

    public BulbAdapter(LegacyBulb bulb) {
        if (bulb == null) {
            throw new IllegalArgumentException("Bulb reference cannot be null");
        }
        this.bulb = bulb;
    }

    @Override
    public void turnOn() {
        bulb.setBrightness(255);
    }

    @Override
    public void turnOff() {
        bulb.setBrightness(0);
    }

    @Override
    public boolean isOn() {
        if (!bulb.hasPower()) {
            return false;
        }
        return bulb.readBrightness() > 0;
    }

    @Override
    public int getPowerPercent() {
        if (!bulb.hasPower() || bulb.readBrightness() == 0) {
            return 0;
        }
        int rawBrightness = bulb.readBrightness();
        int rawPercent = (int) Math.floor((rawBrightness * 100.0) / 255.0);
        int calibratedPercent = rawPercent + K;

        return Math.min(100, calibratedPercent);
    }
}
