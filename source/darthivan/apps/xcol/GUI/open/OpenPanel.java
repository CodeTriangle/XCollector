package darthivan.apps.xcol.GUI.open;

import darthivan.apps.xcol.Variables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class OpenPanel extends JPanel{

    Image splash;

    public OpenPanel() throws IOException {
        splash = ImageIO.read(new File(Variables.SPLASH_FILE));
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(splash, 0, 0, 400, 300, null);
    }
}
