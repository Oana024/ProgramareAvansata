package laborator6.classes;

import javax.swing.*;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerCols;
    JSpinner spinnerRows;
    JButton createBtn = new JButton("Create");

    public ConfigPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        label = new JLabel("Grid size:");
        spinnerRows = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));
        spinnerCols = new JSpinner(new SpinnerNumberModel(10, 2, 100, 1));

        add(label);
        add(spinnerRows);
        add(spinnerCols);
        add(createBtn);
    }

    public int getRows() {
        return 10;
    }

    public int getCols() {
        return 10;
    }

}
