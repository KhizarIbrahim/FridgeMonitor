import pharmacy.FridgeSystem;
import pharmacy.SensorFaultException;

public class Main {
    public static void main(String[] args) {
        FridgeSystem system = new FridgeSystem();

        try {
            double temp = system.getTemperature(0);
            System.out.println("Vaccine Fridge temperature: " + temp);
        } catch (SensorFaultException e) {
            System.out.println("Sensor fault: " + e.getMessage());
        }
    }
}
