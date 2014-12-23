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

        thingPanel = new JPanel(new GridLayout(1, 3));
        buttonPanel = new JPanel(new GridLayout(1, 2));

        collectionButton = new JRadioButton("Collection");
        seriesButton = new JRadioButton("Series");
        itemButton = new JRadioButton("Item");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        thingGroup = new ButtonGroup();

        this.setLayout(new GridLayout(2, 1));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

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
