package darthivan.apps.xcol.GUI.create;

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

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        createCollectionFrame = new CreateCollectionFrame("Create Collection");

        thingPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        buttonPanel = new JPanel(new GridLayout(1, 2));

        collectionButton = new JRadioButton("Collection");
        seriesButton = new JRadioButton("Series");
        itemButton = new JRadioButton("Item");
        imageButton = new JRadioButton("Image");

        collectionButton.setActionCommand(collectionButtonName);
        seriesButton.setActionCommand(seriesButtonName);
        itemButton.setActionCommand(itemButtonName);

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        thingGroup = new ButtonGroup();

        okButton.setBackground(new Color(0, 200, 0));
        cancelButton.setBackground(new Color(240, 0, 0));

        this.setLayout(new GridLayout(2, 1));
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

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

        this.pack();
        this.setLocationRelativeTo(null);

        collectionButton.addActionListener(this);
        seriesButton.addActionListener(this);
        itemButton.addActionListener(this);
        okButton.addActionListener(this);
    }

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
        else if (e.getActionCommand().equals("Cancel")) {
            this.setVisible(false);
        }
    }
}
