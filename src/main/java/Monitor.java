import pharmacy.FridgeSystem;
import pharmacy.SensorFaultException;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Monitor {
    private final FridgeSystem system;
    private final ArrayList<StorageUnit> units;
    private final ArrayList<JPanel> panels = new ArrayList<>();
    private final ArrayList<JLabel> labels = new ArrayList<>();

    public Monitor(FridgeSystem system, ArrayList<StorageUnit> units) {
        this.system = system;
        this.units = units;
    }

    public void createWindow() {
        JFrame frame = new JFrame("Pharmacy Fridge Monitor");
        frame.setLayout(new GridLayout(1, units.size()));

        for (StorageUnit unit : units) {
            JPanel panel = new JPanel();
            JLabel label = new JLabel(unit.getName());
            panel.add(label);
            panel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            frame.add(panel);

            panels.add(panel);
            labels.add(label);
        }

        frame.setSize(750, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void update() {
        for (int i = 0; i < units.size(); i++) {
            StorageUnit unit = units.get(i);
            JLabel label = labels.get(i);

            try {
                double temp = system.getTemperature(unit.getId());
                boolean coolingOn = system.isCoolingOn(unit.getId());

                label.setText("<html><b>" + unit.getName() + "</b><br>"
                        + "Temp: " + String.format("%.1f", temp) + " C<br>"
                        + "Safe: " + unit.getMinTemp() + " to " + unit.getMaxTemp() + " C<br>"
                        + "Cooling: " + (coolingOn ? "ON" : "OFF")
                        + "</html>");
            } catch (SensorFaultException e) {
                label.setText("<html><b>" + unit.getName() + "</b><br>SENSOR FAULT</html>");
            }
        }
    }
}
