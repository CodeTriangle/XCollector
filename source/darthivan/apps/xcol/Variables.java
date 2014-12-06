package darthivan.apps.xcol;

import java.awt.*;
import java.io.File;

public class Variables {
    public static final String USER_DIR = System.getProperty("user.dir");
    public static final String ASSET_DIR = USER_DIR + "/assets";
    public static final String SOURCE_DIR = USER_DIR + "/source";
    public static final String DATA_DIR = USER_DIR + "/data";
    public static final String SPLASH_FILE = ASSET_DIR + "/splash.png";

    public static final File USER_DIR_F = new File(USER_DIR);
    public static final File ASSET_DIR_F = new File(ASSET_DIR);
    public static final File SOURCE_DIR_F = new File(SOURCE_DIR);
    public static final File DATA_DIR_F = new File(DATA_DIR);
    public static final File SPLASH_FILE_F = new File(SPLASH_FILE);

    public static final Font TNR = new Font("Times New Roman", Font.PLAIN, 15);
}
