package laborator6.classes;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class ControlPanel extends JPanel {
    final MainFrame frame;
    JButton exitBtn = new JButton("Exit");
    JButton loadBtn = new JButton("Load");
    JButton saveBtn = new JButton("Save");
    JButton exportBtn = new JButton("Export as PNG");

    public ControlPanel(MainFrame frame) {
        this.frame = frame;
        init();
    }

    private void init() {
        setLayout(new GridLayout(1, 4));

        add(exportBtn);
        add(saveBtn);
        add(loadBtn);
        add(exitBtn);

        exitBtn.addActionListener(this::exitGame);
        exportBtn.addActionListener(this::exportAsPNG);
    }

    private void exitGame(ActionEvent e) {
        frame.dispose();
    }

    private void exportAsPNG(ActionEvent e) {
        BufferedImage image = frame.canvas.getImage();

        try {
            ImageIO.write(image, "png", new File("drawing.png"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
