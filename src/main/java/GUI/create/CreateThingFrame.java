package GUI.create;

import main.Variables;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateThingFrame extends JFrame implements ActionListener {
    JFrame createCollectionFrame;

    JPanel thingPanel;
    JPanel buttonPanel;

    JRadioButton collectionButton;
    JRadioButton seriesButton;
    JRadioButton itemButton;
    JRadioButton imageButton;

    JButton okButton;
    JButton cancelButton;

    ButtonGroup thingGroup;

    public static final String collectionButtonName = "collection";
    public static final String seriesButtonName = "series";
    public static final String itemButtonName = "item";
    public static final String imageButtonName = "image";

    public CreateThingFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Set look and feel to ♥Nimbus♥

        // Initiate Create dialogues
        createCollectionFrame = new CreateCollectionFrame("Create Collection");

        thingPanel = new JPanel(new FlowLayout()); // The panel of things you can create.
        buttonPanel = new JPanel(new FlowLayout()); // The panel that holds the buttons.

        // Initiate the radio buttons for the things that you can create.
        collectionButton = new JRadioButton("Collection");
        seriesButton = new JRadioButton("Series");
        itemButton = new JRadioButton("Item");
        imageButton = new JRadioButton("Image");

        // Add the action commands for the buttons.
        collectionButton.setActionCommand(collectionButtonName);
        seriesButton.setActionCommand(seriesButtonName);
        itemButton.setActionCommand(itemButtonName);
        imageButton.setActionCommand(imageButtonName);

        // Initiate the buttons for okay and cancel.
        okButton = new JButton("OK", Variables.checkIcon);
        cancelButton = new JButton("Cancel", Variables.cancelIcon);

        thingGroup = new ButtonGroup(); // Makes the radio buttons work.

        // Set window properties.
        this.setLayout(new GridLayout(2, 1));
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        // Add stuff to stuff.
        thingGroup.add(collectionButton);
        thingGroup.add(seriesButton);
        thingGroup.add(itemButton);
        thingGroup.add(imageButton);

        thingPanel.add(collectionButton);
        thingPanel.add(seriesButton);
        thingPanel.add(itemButton);
        thingPanel.add(imageButton);

        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        this.add(thingPanel);
        this.add(buttonPanel);

        this.pack(); //Put this window at the absolute minimum size it will go.
        this.setLocationRelativeTo(null); // Center this window in the screen.

        // Add action listeners.
        collectionButton.addActionListener(this);
        seriesButton.addActionListener(this);
        itemButton.addActionListener(this);
        imageButton.addActionListener(this);
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }

    // Functions to open windows for creation frames.
    private void collectionFunction() {
        createCollectionFrame.setVisible(true);
        this.setVisible(false);
        System.out.println("CreateCollectionFrame Active");
    }

    private void seriesFunction() {
        System.out.println("CreateSeriesFrame Active");
    }

    private void itemFunction() {
        System.out.println("CreateItemFrame Active");
    }

    private void imageFunction() {
        System.out.println("CreateImageFrame Active");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            switch (thingGroup.getSelection().getActionCommand()) {
                case collectionButtonName :
                    collectionFunction();
                    break;
                case seriesButtonName :
                    seriesFunction();
                    break;
                case itemButtonName :
                    itemFunction();
                    break;
                case imageButtonName :
                    imageFunction();
                    break;
                default :
                    System.out.print("oops mistake");
                    break;
            }
        }
        if (e.getActionCommand().equals("Cancel")) {
            this.setVisible(false);
            System.out.println("CreateThingFrame Closed");
        }
    }
}
