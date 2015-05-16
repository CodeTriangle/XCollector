package main;

import GUI.collection.CollectionFrame;
import GUI.open.OpenFrame;
import org.json.simple.JSONValue;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Main {
    public static JFrame openFrame;
    public static JFrame collectionFrame;

    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException, InterruptedException {
        openFrame = new OpenFrame(); // Splash screen
        collectionFrame = new CollectionFrame("XCollector"); // This is the main window that most of the program will take place in

        openFrame.setVisible(true);

        Thread.sleep(1000L); // Sleep 1 second to show the splash screen

        // Create the data directory if it doesn't already exist
        if (!Reference.DATA_DIR_F.exists()) {
            if (Reference.DATA_DIR_F.mkdir()) {
                System.out.println("Data directory created.");
            }
        }

        if (!Reference.COLLECTION_FILE_F.exists()) {
            System.out.println("Collections file created.");

            Map object = new HashMap<>();
            object.put("test1", "Test 1");
            object.put("test2", new Random().nextInt());
            object.put("test3", true);
            object.put("test4", null);
            object.put("test5", new Random().nextFloat());

            String jsonString = JSONValue.toJSONString(object);
            PrintWriter out = null;
            try {
                out = new PrintWriter(new File(Reference.COLLECTION_FILE));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            out.println(jsonString);
            out.close();
            System.out.println(jsonString);
        }

        openFrame.setVisible(false); // Turn off the splash screen
        collectionFrame.setVisible(true); // Turn on the main XCollector window.
    }
}
