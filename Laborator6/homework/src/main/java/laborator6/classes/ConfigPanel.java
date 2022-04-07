package laborator6.classes;

import javax.swing.*;
import java.awt.event.ActionEvent;

import static java.awt.BorderLayout.CENTER;

public class ConfigPanel extends JPanel {
    final MainFrame frame;
    JLabel label;
    JSpinner spinnerCols;
    JSpinner spinnerRows;
    JButton createBtn = new JButton("Create");
    int rows, cols;

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

        createBtn.addActionListener(this::createGame);
    }

    private void createGame(ActionEvent e) {
        rows = (Integer) spinnerRows.getValue();
        cols = (Integer) spinnerCols.getValue();
        frame.canvas.changeDim();
    }


    public int getRows() {
        int value = (Integer) spinnerRows.getValue();
        return value;
    }

    public int getCols() {
        int value = (Integer) spinnerCols.getValue();
        return value;
    }

}
