package pharmacy;

/**
 * Thrown when a fridge sensor fails to give a reading.
 * GIVEN CODE - do not change (except adding the package line).
 */
public class SensorFaultException extends Exception {
    public SensorFaultException(String message) {
        super(message);
    }
}
