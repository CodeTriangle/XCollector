package darthivan.apps.xcol.GUI.open;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class ImagePanel extends JPanel{

    Image image;
    int w, h;

    public ImagePanel(String str) throws IOException {
        image = ImageIO.read(new File(str));
    }

    public ImagePanel(String str, int wid, int hei) throws IOException {
        image = ImageIO.read(new File(str));
        w = wid;
        h = hei;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), null);
    }
}
