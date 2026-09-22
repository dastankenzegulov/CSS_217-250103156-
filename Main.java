import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("============================================================");
        System.out.println(" OMNIHOME SMART CONTROLLER: SYSTEM STARTUP");
        System.out.println("============================================================");

        LegacyBulb rawBulb = new LegacyBulb();
        LegacyThermostat rawThermostat = new LegacyThermostat();

        SmartDevice bulbAdapter = new BulbAdapter(rawBulb);
        SmartDevice thermostatAdapter = new ThermostatAdapter(rawThermostat);

        List<SmartDevice> deviceList = List.of(bulbAdapter, thermostatAdapter);
        ModernHub hub = new ModernHub(deviceList);

        System.out.println("--- OPERATION: ACTIVATE ALL DEVICES ---");
        hub.activateAll();
        System.out.println("[Status] All devices active");

        // 6-қадам: Орташа қуат тұтынуын есептеу
        double avgPower = hub.calculateAveragePowerUsage();
        System.out.printf("[Power] Fleet Average Power Usage: %.2f%%\n", avgPower);

        // 7-қадам: Апаттық өшіру
        System.out.println("--- OPERATION: EMERGENCY SHUTDOWN ---");
        hub.emergencyShutdown();
        System.out.printf("[Power] Fleet Average Power Usage after shutdown: %.2f%%\n", hub.calculateAveragePowerUsage());
        System.out.println("============================================================");
    }
}