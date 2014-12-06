package darthivan.apps.xcol.GUI.open;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class OpenFrame extends JFrame {

    public static JPanel openPanel;

    public OpenFrame() throws HeadlessException, IOException {

        openPanel = new OpenPanel();

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
