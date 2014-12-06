package darthivan.apps.xcol;

import darthivan.apps.xcol.GUI.collection.CollectionFrame;
import darthivan.apps.xcol.GUI.open.*;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Main {
    public static JFrame openFrame;
    public static JFrame collectionFrame;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
            openFrame = new OpenFrame();
            collectionFrame = new CollectionFrame("XCollector");

        openFrame.setVisible(true);

        Thread.sleep(1000L);

        if (!Variables.DATA_DIR_F.exists()) {
            if (Variables.DATA_DIR_F.mkdir()) {
                System.out.println("Data directory created.");
            }
        }

        openFrame.setVisible(false);
        collectionFrame.setVisible(true);
    }
}
