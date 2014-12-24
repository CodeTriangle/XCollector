package darthivan.apps.xcol.GUI.create;

import javax.swing.*;
import java.awt.*;

public class CreateThingFrame extends JFrame {
    JPanel thingPanel;
    JPanel buttonPanel;

    JRadioButton collectionButton;
    JRadioButton seriesButton;
    JRadioButton itemButton;

    JButton okButton;
    JButton cancelButton;

    ButtonGroup thingGroup;

    public CreateThingFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        thingPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel = new JPanel(new GridLayout(1, 2));

        collectionButton = new JRadioButton("Collection");
        seriesButton = new JRadioButton("Series");
        itemButton = new JRadioButton("Item");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        thingGroup = new ButtonGroup();

        okButton.setBackground(new Color(0, 203, 0));
        cancelButton.setBackground(new Color(218, 83, 70));

        this.setLayout(new GridLayout(2, 1));
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        thingGroup.add(collectionButton);
        thingGroup.add(seriesButton);
        thingGroup.add(itemButton);

        thingPanel.add(collectionButton);
        thingPanel.add(seriesButton);
        thingPanel.add(itemButton);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        this.add(thingPanel);
        this.add(buttonPanel);

        this.pack();
    }
}
