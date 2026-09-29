# Smart Home IoT Integration (Object Adapter Pattern)

This project demonstrates the implementation of the **Object Adapter Pattern** in Java for integrating legacy appliances (`LegacyBulb`, `LegacyThermostat`) into the `ModernHub` system using the `SmartDevice` target interface.

## Project Structure
- `SmartDevice.java`: Target interface
- `LegacyBulb.java`, `LegacyThermostat.java`: Legacy adaptees
- `BulbAdapter.java`, `ThermostatAdapter.java`: Object adapters
- `ModernHub.java`: Client class
- `Main.java`: Integration driver and unit/fault tests
