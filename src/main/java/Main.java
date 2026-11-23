import pharmacy.FridgeSystem;
import pharmacy.SensorFaultException;
import java.util.ArrayList;
import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        FridgeSystem system = new FridgeSystem();

        try {
            double temp = system.getTemperature(0);
            System.out.println("Vaccine Fridge temperature: " + temp);
        } catch (SensorFaultException e) {
            System.out.println("Sensor fault: " + e.getMessage());
        }

        ArrayList<StorageUnit> units = new ArrayList<>();
        units.add(new VaccineFridge(0));
        units.add(new BloodFridge(1));
        units.add(new Freezer(2));

        for (StorageUnit unit : units) {
            System.out.println(unit);
        }

        Monitor monitor = new Monitor(system, units);
        monitor.createWindow();

        Timer timer = new Timer(1000, e -> monitor.update());
        timer.start();
    }
}
