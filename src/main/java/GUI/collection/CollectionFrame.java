package GUI.collection;

import GUI.create.CreateThingFrame;
import main.Reference;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CollectionFrame extends JFrame implements ActionListener {

    public JFrame createFrame;

    public JPanel labelPanel;
    public JPanel listButtonPanel;
    public JPanel listPanel;
    public JPanel topButtonPanel;
    public JPanel collectionsButtonPanel;
    public JPanel seriesesButtonPanel;
    public JPanel itemsButtonPanel;
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

    public JButton openCButton;
    public JButton deleteCButton;

    public JButton openSButton;
    public JButton deleteSButton;

    public JButton openIButton;
    public JButton deleteIButton;

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
        listButtonPanel = new JPanel(); // Panel to hold all the lists and corresponding buttons
        listPanel = new JPanel(); // Where all the lists are held for Collections, Serieses, and Items
        topButtonPanel = new JPanel(); // Panel for all the create and delete buttons
        collectionsButtonPanel = new JPanel(); // Buttons for the collections
        seriesesButtonPanel = new JPanel(); // Buttons for the serieses
        itemsButtonPanel = new JPanel(); // Buttons for the items
        itemButtonPanel = new JPanel(new BorderLayout()); // A Panel to hold the item display and the buttons
        itemPanel = new JPanel(); // Item display
        buttonPanel = new JPanel(); // All the buttons.
        imagePanel = new SquareImagePanel(Reference.PLACEHOLDER_FILE_F, SquareImagePanel.TALL); // Picture of the item for item display
        detailsPanel = new JPanel(); // Details of the item for item display

        // Initiate the collection lists with type String.
        collectionList = new JList<>(collectionArray);
        seriesList = new JList<>(seriesArray);
        itemList = new JList<>(itemArray);

        // Initiate the buttons with text and an Icon.
        openCButton = new JButton("Open Collection", Reference.checkIcon);
        deleteCButton = new JButton("Delete Collection", Reference.cancelIcon);

        openSButton = new JButton("Open Series", Reference.checkIcon);
        deleteSButton = new JButton("Delete Series", Reference.cancelIcon);

        openIButton = new JButton("Open Item", Reference.checkIcon);
        deleteIButton = new JButton("Delete Item", Reference.cancelIcon);

        createButton = new JButton("Create", Reference.addIcon);

        // Stuff for description panel.
        titleField = new JTextField("1900 Penny");
        descriptionArea = new JTextArea("I bought this from a shady street vendor in 2000. He sold me this for 5 " +
                "dollars. Said it was a rare coin. I trusted him.");

        collectedBox = new JCheckBox("Collected?", false); // Check this box if you have the item already.

        line = BorderFactory.createLineBorder(new Color(105, 105, 105)); // Specify a new border.

        // Set the font for all the things to Times New Roman.
        collectionList.setFont(Reference.TNR);
        seriesList.setFont(Reference.TNR);
        itemList.setFont(Reference.TNR);
        titleField.setFont(Reference.TNR_LARGE);

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

        itemButtonPanel.setLayout(new BorderLayout());
        listPanel.setLayout(new GridLayout(1, 5, 10, 10));
        itemPanel.setLayout(new GridLayout());
        buttonPanel.setLayout(new FlowLayout());
        detailsPanel.setLayout(new BorderLayout(10, 10));

        descriptionArea.setLineWrap(true); // Set the line wrap for description area.

        // Set window properties.
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        // Add things to other things.
        listPanel.add(collectionList);
        listPanel.add(seriesList);
        listPanel.add(itemList);

        itemPanel.add(imagePanel);
        itemPanel.add(detailsPanel);

        buttonPanel.add(createButton);

        detailsPanel.add(titleField, BorderLayout.NORTH);
        detailsPanel.add(descriptionArea, BorderLayout.CENTER);
        detailsPanel.add(collectedBox, BorderLayout.SOUTH);

        itemButtonPanel.add(itemPanel, BorderLayout.CENTER);
        itemButtonPanel.add(buttonPanel, BorderLayout.SOUTH);

        this.add(listPanel);
        this.add(itemButtonPanel);

        openCButton.addActionListener(this);
        deleteCButton.addActionListener(this);
        createButton.addActionListener(this);
    }

    // Functions for button clicks.
    private void openCFunction() {
        Reference.pressedMessage(openCButton.getText());
    }

    private void deleteFunction() {
        System.out.println("Delete Button Pressed");
    }

    private void createFunction() {
        createFrame.setVisible(true);
        Reference.pressedMessage(createButton.getText());
    }

    // Function for events.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Open Collection"))
            openCFunction();
        else if (e.getActionCommand().equals("Delete"))
            deleteFunction();
        else if (e.getActionCommand().equals("Create"))
            createFunction();
    }
}
