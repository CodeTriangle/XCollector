package darthivan.apps.xcol;

import darthivan.apps.xcol.GUI.OpenPanel;
import darthivan.apps.xcol.GUI.SelectFrame;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;

public class Main {
    public static JFrame openFrame;
    public static JFrame selectFrame;
    public static JPanel openPanel;

    public static void main(String[] args) {
        openFrame = new JFrame("XCollector");
        selectFrame = new SelectFrame();
        try {
            openPanel = new OpenPanel();
        } catch (IOException e) {
            e.printStackTrace();
        }

        openFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        openFrame.setLayout(new BorderLayout());
        openFrame.setSize(400, 300);
        openFrame.setUndecorated(true);
        openFrame.setLocationRelativeTo(null);

        openFrame.add(openPanel, BorderLayout.CENTER);

        openFrame.setVisible(true);
        openFrame.setResizable(false);

        long nanoTime = System.nanoTime();
        boolean nanoTimeReached = false;

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        openFrame.setVisible(false);
        openFrame.dispose();

        selectFrame.setVisible(true);
    }
}
