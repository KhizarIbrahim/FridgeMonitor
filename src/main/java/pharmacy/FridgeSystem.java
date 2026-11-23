package pharmacy;

import java.util.Random;

/**
 * Simulates the temperature sensors and cooling units of the hospital pharmacy.
 * GIVEN CODE - do not change (except adding the package line).
 *
 * Unit ids: 0 = Vaccine Fridge, 1 = Blood Fridge, 2 = Freezer
 */
public class FridgeSystem {

    public static final String[] UNITS = {"Vaccine Fridge", "Blood Fridge", "Freezer"};

    private final double[] temps = {5.0, 4.0, -20.0};
    private final boolean[] cooling = {true, true, true};
    private final Random rand = new Random();

    /**
     * Returns the current temperature (degrees C) of a unit.
     * Each call moves the simulation on a little, so read each unit ONCE per second.
     * Occasionally the sensor fails and a SensorFaultException is thrown.
     */
    public double getTemperature(int id) throws SensorFaultException {
        checkId(id);
        if (rand.nextInt(25) == 0) {
            throw new SensorFaultException(UNITS[id] + " sensor did not respond");
        }
        temps[id] += cooling[id] ? -0.3 : 0.4;
        if (rand.nextInt(40) == 0) {
            temps[id] += 3.0;
            System.out.println("** Door opened on " + UNITS[id] + " **");
        }
        return temps[id];
    }

    public boolean isCoolingOn(int id) {
        checkId(id);
        return cooling[id];
    }

    public void turnCoolingOn(int id) {
        checkId(id);
        cooling[id] = true;
        System.out.println(UNITS[id] + " cooling ON");
    }

    public void turnCoolingOff(int id) {
        checkId(id);
        cooling[id] = false;
        System.out.println(UNITS[id] + " cooling OFF");
    }

    private void checkId(int id) {
        if (id < 0 || id >= UNITS.length) {
            throw new IllegalArgumentException("No unit with id " + id);
        }
    }
}
