package darthivan.apps.xcol.GUI.collection;

import darthivan.apps.xcol.Variables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SquareImagePanel extends JPanel{

    Image image;
    SquareImagePanelMode mode;

    public SquareImagePanel(String str, SquareImagePanelMode mod) throws IOException {
        image = ImageIO.read(new File(str));
        mode = mod;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (mode == SquareImagePanelMode.TALL)
            g.drawImage(image, (int) ((.5 * this.getWidth()) - (.5 * image.getWidth(null))), 5, this.getHeight(), this.getHeight() - 5, null);
        else if (mode == SquareImagePanelMode.WIDE)
            g.drawImage(image, (int) ((.5 * this.getWidth()) - (.5 * image.getWidth(null))), 5, this.getWidth(), this.getWidth() - 5, null);
    }
}
