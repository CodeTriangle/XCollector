package darthivan.apps.xcol.GUI.open;

import darthivan.apps.xcol.Variables;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenFrame extends JFrame {

    public static JPanel openPanel;

    public OpenFrame() throws HeadlessException, IOException {

        openPanel = new ImagePanel(Variables.SPLASH_FILE, 400, 300);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());
        this.setSize(400, 300);
        this.setUndecorated(true);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setLayout(new BorderLayout());

        this.add(openPanel);
    }
}
