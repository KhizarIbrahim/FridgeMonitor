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

}
