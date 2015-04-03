package darthivan.apps.xcol.GUI.collection;

import darthivan.apps.xcol.GUI.create.CreateThingFrame;
import darthivan.apps.xcol.Variables;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CollectionFrame extends JFrame implements ActionListener {

    public JFrame createFrame;

    public JPanel labelPanel;
    public JPanel listPanel;
    public JPanel itemButtonPanel;
    public JPanel itemPanel;
    public JPanel buttonPanel;
    public JPanel imagePanel;
    public JPanel detailsPanel;

    public String collectionArray[];
    public String seriesArray[];
    public String itemArray[];

    public JList<String> collectionList;
    public JList<String> seriesList;
    public JList<String> itemList;

    public JButton openButton;
    public JButton deleteButton;
    public JButton createButton;

    public JTextField titleField;

    public JTextArea descriptionArea;

    public JCheckBox collectedBox;

    public Border line;

    public CollectionFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Set the look and feel to ♥Nimbus♥

        collectionArray = new String[] {""}; // The place where all the collections are held.
        seriesArray = new String[] {""}; // The place where all the serieses in the collection are held.
        itemArray = new String[] {""}; // The place where the individual items in the collection are held.

        createFrame = new CreateThingFrame("Create What?"); // This frame  Controls all creations of everything.

        labelPanel = new JPanel(); // Not used yet. TODO: Add labels to CollectionFrame.
        listPanel = new JPanel(); // Where all the lists are held for Collections, Serieses, and Items.
        itemButtonPanel = new JPanel(); // A Panel to hold the item display and the buttons.
        itemPanel = new JPanel(); // Item display
        buttonPanel = new JPanel(); // All the buttons.
        imagePanel = new SquareImagePanel(Variables.PLACEHOLDER_FILE_F, SquareImagePanel.TALL); // Picture of the item for item display
        detailsPanel = new JPanel(); // Details of the item for item display

        // Initiate the collection lists with type String.
        collectionList = new JList<>(collectionArray);
        seriesList = new JList<>(seriesArray);
        itemList = new JList<>(itemArray);

        // Initiate the buttons with text and an Icon.
        openButton = new JButton("Open", Variables.checkIcon);
        deleteButton = new JButton("Delete", Variables.cancelIcon);
        createButton = new JButton("Create", Variables.addIcon);

        // Stuff for description panel.
        titleField = new JTextField("1900 Penny");
        descriptionArea = new JTextArea("I bought this from a shady street vendor in 2000. He sold me this for 5 " +
                "dollars. Said it was a rare coin. I trusted him.");

        collectedBox = new JCheckBox("Collected?", false); // Check this box if you have the item already.

        line = BorderFactory.createLineBorder(new Color(105, 105, 105)); // Specify a new border.

        // Set the font for all the things to Times New Roman.
        collectionList.setFont(Variables.TNR);
        seriesList.setFont(Variables.TNR);
        itemList.setFont(Variables.TNR);
        titleField.setFont(Variables.TNR_LARGE);

        // Color the Lists and description panel.
        collectionList.setBackground(new Color(135, 135, 135));
        seriesList.setBackground(new Color(155, 155, 155));
        itemList.setBackground(new Color(175, 175, 175));

        collectionList.setForeground(new Color(235, 235, 235));
        seriesList.setForeground(new Color(245, 245, 245));
        itemList.setForeground(new Color(255, 255, 255));

        titleField.setBackground(new Color(156, 156, 156));
        titleField.setForeground(new Color(255,255,255));

        descriptionArea.setBackground(new Color(155, 155, 155));
        descriptionArea.setForeground(new Color(255,255,255));

        // Add Border.
        collectionList.setBorder(line);
        seriesList.setBorder(line);
        itemList.setBorder(line);
        titleField.setBorder(line);
        descriptionArea.setBorder(line);

        // Set the layout of all of the panels.
        this.setLayout(new GridLayout(2,1));
        itemButtonPanel.setLayout(new BorderLayout());
        listPanel.setLayout(new GridLayout(1, 5, 10, 10));
        itemPanel.setLayout(new GridLayout());
        buttonPanel.setLayout(new FlowLayout());
        detailsPanel.setLayout(new BorderLayout(10, 10));

        descriptionArea.setLineWrap(true); // Set the line wrap for description area.

        // Set window properties.
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        // Add things to other things.
        listPanel.add(collectionList);
        listPanel.add(seriesList);
        listPanel.add(itemList);

        itemPanel.add(imagePanel);
        itemPanel.add(detailsPanel);

        buttonPanel.add(openButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(createButton);

        detailsPanel.add(titleField, BorderLayout.NORTH);
        detailsPanel.add(descriptionArea, BorderLayout.CENTER);
        detailsPanel.add(collectedBox, BorderLayout.SOUTH);

        itemButtonPanel.add(itemPanel, BorderLayout.CENTER);
        itemButtonPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(listPanel);
        this.add(itemButtonPanel);

        openButton.addActionListener(this);
        deleteButton.addActionListener(this);
        createButton.addActionListener(this);
    }

    // Functions for button clicks.
    private void openFunction(){
        System.out.println("Open Button Pressed");
    }

    private void deleteFunction() {
        System.out.println("Delete Button Pressed");
    }

    private void createFunction() {
        createFrame.setVisible(true);
        System.out.println("Create Button Pressed");
    }

    // Function for events.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open"))
            openFunction();
        else if (e.getActionCommand().equals("Delete"))
            deleteFunction();
        else if (e.getActionCommand().equals("Create"))
            createFunction();
    }
}
