package main;

import javax.swing.*;
import java.awt.*;
import java.io.File;

public class Reference {
    public static final String USER_DIR = "src/main";
    public static final String SOURCE_DIR = USER_DIR + "/java";
    public static final String ASSET_DIR = USER_DIR + "/resources";
    public static final String DATA_DIR = "data";
    public static final String COLLECTION_FILE = DATA_DIR + "/data.xc";
    public static final String SPLASH_FILE = ASSET_DIR + "/splash.png";
    public static final String PLACEHOLDER_FILE = ASSET_DIR + "/placeholder.png";
    public static final String ADD_FILE = ASSET_DIR + "/add.png";
    public static final String CANCEL_FILE = ASSET_DIR + "/cancel.png";
    public static final String CHECK_FILE = ASSET_DIR + "/check.png";
    public static final String FRAME_FILE = ASSET_DIR + "/.png";

    public static final File USER_DIR_F = new File(USER_DIR);
    public static final File ASSET_DIR_F = new File(ASSET_DIR);
    public static final File SOURCE_DIR_F = new File(SOURCE_DIR);
    public static final File DATA_DIR_F = new File(DATA_DIR);
    public static final File COLLECTION_FILE_F = new File(COLLECTION_FILE);
    public static final File SPLASH_FILE_F = new File(SPLASH_FILE);
    public static final File PLACEHOLDER_FILE_F = new File(PLACEHOLDER_FILE);
    public static final File ADD_FILE_F = new File(ADD_FILE);
    public static final File CANCEL_FILE_F = new File(CANCEL_FILE);
    public static final File CHECK_FILE_F = new File(CHECK_FILE);
    public static final File FRAME_FILE_F = new File(FRAME_FILE);

    public static ImageIcon addIcon = new ImageIcon(ADD_FILE);
    public static ImageIcon cancelIcon = new ImageIcon(CANCEL_FILE);
    public static ImageIcon checkIcon = new ImageIcon(CHECK_FILE);
    public static ImageIcon frameIcon = new ImageIcon(FRAME_FILE);

    public static final Font TNR = new Font("Times New Roman", Font.PLAIN, 15);
    public static final Font TNR_LARGE = new Font("Times New Roman", Font.BOLD, 25);

    public static void pressedMessage (String s) {
        System.out.printf("Button with command \"%s\" pressed.", s);
        System.out.println();
    }

    public static void activeMessage (String s) {
        System.out.printf("Window with name \"%s\" active.", s);
        System.out.println();
    }

    public static void closedMessage (String s) {
        System.out.printf("Window with name \"%s\" closed.", s);
        System.out.println();
    }
}
