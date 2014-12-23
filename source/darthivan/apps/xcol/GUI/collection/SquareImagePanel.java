package darthivan.apps.xcol.GUI.collection;

import darthivan.apps.xcol.Variables;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class SquareImagePanel extends JPanel{

    private Image image;
    private int mode;

    public static final int WIDE = 0;
    public static final int TALL = 1;

    public SquareImagePanel(String str, int mod) throws IOException {
        image = ImageIO.read(new File(str));
        mode = mod;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (mode == this.TALL)
            g.drawImage(image, (int) ((.5 * this.getWidth()) - (.5 * image.getWidth(null))), 5, this.getHeight(), this.getHeight() - 5, null);
        else if (mode == this.WIDE)
            g.drawImage(image, (int) ((.5 * this.getWidth()) - (.5 * image.getWidth(null))), 5, this.getWidth(), this.getWidth() - 5, null);
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getMode() {
        return mode;
    }

    public void setMode(int mode) {
        this.mode = mode;
    }
}
