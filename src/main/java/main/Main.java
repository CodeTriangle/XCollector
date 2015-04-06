package main;

import GUI.collection.CollectionFrame;
import GUI.open.OpenFrame;

import javax.swing.*;
import java.io.IOException;

public class Main {
    public static JFrame openFrame;
    public static JFrame collectionFrame;
    public static JFrame createThingFrame;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
        openFrame = new OpenFrame(); // Splash screen
        collectionFrame = new CollectionFrame("XCollector"); // This is the main window that most of the program will take place in

        openFrame.setVisible(true);

        Thread.sleep(1000L); // Sleep 1 second to show the splash screen

        // Create the data directory if it doesn't already exist
        if (!Variables.DATA_DIR_F.exists()) {
            if (Variables.DATA_DIR_F.mkdir()) {
                System.out.println("Data directory created.");
            }
        }

        openFrame.setVisible(false); // Turn off the splash screen
        collectionFrame.setVisible(true); // Turn on the main XCollector window.
    }
}
