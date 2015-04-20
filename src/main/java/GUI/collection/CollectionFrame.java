package GUI.collection;

import GUI.create.CreateCollectionFrame;
import main.Reference;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CollectionFrame extends JFrame implements ActionListener {

    public JFrame createCollectionFrame;
    public JFrame createSeriesFrame;
    public JFrame createItemFrame;

    public JPanel labelPanel;
    public JPanel listButtonPanel;
    public JPanel listPanel;
    public JPanel buttonPanel;
    public JPanel collectionsButtonPanel;
    public JPanel seriesesButtonPanel;
    public JPanel itemsButtonPanel;
    public JPanel itemPanel;
    public JPanel imagePanel;
    public JPanel detailsPanel;
    public JPanel detailsButtonPanel;

    public String collectionArray[];
    public String seriesArray[];
    public String itemArray[];

    public JList<String> collectionList;
    public JList<String> seriesList;
    public JList<String> itemList;

    public JButton openCButton;
    public JButton deleteCButton;
    public JButton createCButton;

    public JButton openSButton;
    public JButton deleteSButton;
    public JButton createSButton;

    public JButton openIButton;
    public JButton deleteIButton;
    public JButton createIButton;

    public JButton addImageButton;

    public JTextField titleField;

    public JTextArea descriptionArea;

    public JCheckBox collectedBox;

    public Border line;

    public CollectionFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException, IOException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Set the look and feel to ♥Nimbus♥

        createCollectionFrame = new CreateCollectionFrame("Create Collection...");

        collectionArray = new String[] {""}; // The place where all the collections are held.
        seriesArray = new String[] {""}; // The place where all the serieses in the collection are held.
        itemArray = new String[] {""}; // The place where the individual items in the collection are held.

        labelPanel = new JPanel(); // Not used yet. TODO: Add labels to CollectionFrame.
        listButtonPanel = new JPanel(new BorderLayout()); // Panel to hold all the lists and corresponding buttons
        listPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // Where all the lists are held for Collections, Serieses, and Items
        buttonPanel = new JPanel(new GridLayout(1, 3, 10, 10)); // Panel for all the create and delete buttons
        collectionsButtonPanel = new JPanel(new FlowLayout()); // Buttons for the collections
        seriesesButtonPanel = new JPanel(new FlowLayout()); // Buttons for the serieses
        itemsButtonPanel = new JPanel(new FlowLayout()); // Buttons for the items
        itemPanel = new JPanel(new GridLayout()); // Item display
        imagePanel = new SquareImagePanel(Reference.PLACEHOLDER_FILE_F, SquareImagePanel.TALL); // Picture of the item for item display
        detailsPanel = new JPanel(new BorderLayout()); // Details of the item for item display
        detailsButtonPanel = new JPanel(new GridLayout(1, 2));

        // Initiate the collection lists with type String.
        collectionList = new JList<>(collectionArray);
        seriesList = new JList<>(seriesArray);
        itemList = new JList<>(itemArray);

        // Initiate the buttons with text and an Icon.
        openCButton = new JButton(Reference.checkIcon);
        deleteCButton = new JButton(Reference.cancelIcon);
        createCButton = new JButton(Reference.addIcon);

        openSButton = new JButton(Reference.checkIcon);
        deleteSButton = new JButton(Reference.cancelIcon);
        createSButton = new JButton(Reference.addIcon);

        openIButton = new JButton(Reference.checkIcon);
        deleteIButton = new JButton(Reference.cancelIcon);
        createIButton = new JButton(Reference.addIcon);

        addImageButton = new JButton("Add Image");

        openCButton.setActionCommand("openc");
        deleteCButton.setActionCommand("delc");
        createCButton.setActionCommand("crec");

        openSButton.setActionCommand("opens");
        deleteSButton.setActionCommand("dels");
        createSButton.setActionCommand("cres");

        openIButton.setActionCommand("openi");
        deleteIButton.setActionCommand("deli");
        createIButton.setActionCommand("crei");

        addImageButton.setActionCommand("addi");

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

        descriptionArea.setLineWrap(true); // Set the line wrap for description area.

        // Set window properties.
        this.setLayout(new GridLayout(2,1));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setIconImage(Reference.frameIcon.getImage());

        // Add things to other things.
        collectionsButtonPanel.add(openCButton);
        collectionsButtonPanel.add(deleteCButton);
        collectionsButtonPanel.add(createCButton);

        seriesesButtonPanel.add(openSButton);
        seriesesButtonPanel.add(deleteSButton);
        seriesesButtonPanel.add(createSButton);

        itemsButtonPanel.add(openIButton);
        itemsButtonPanel.add(deleteIButton);
        itemsButtonPanel.add(createIButton);

        buttonPanel.add(collectionsButtonPanel);
        buttonPanel.add(seriesesButtonPanel);
        buttonPanel.add(itemsButtonPanel);

        listButtonPanel.add(listPanel, BorderLayout.CENTER);
        listButtonPanel.add(buttonPanel, BorderLayout.SOUTH);

        listPanel.add(collectionList);
        listPanel.add(seriesList);
        listPanel.add(itemList);

        itemPanel.add(imagePanel);
        itemPanel.add(detailsPanel);

        detailsPanel.add(titleField, BorderLayout.NORTH);
        detailsPanel.add(descriptionArea, BorderLayout.CENTER);
        detailsPanel.add(collectedBox, BorderLayout.SOUTH);

        this.add(listButtonPanel);
        this.add(itemPanel);

        openCButton.addActionListener(this);
        deleteCButton.addActionListener(this);
        createCButton.addActionListener(this);

        openSButton.addActionListener(this);
        deleteSButton.addActionListener(this);
        createSButton.addActionListener(this);

        openIButton.addActionListener(this);
        deleteIButton.addActionListener(this);
        createIButton.addActionListener(this);
    }

    // Functions for button clicks.
    private void openCFunction() {
        Reference.pressedMessage(openCButton.getActionCommand());
    }

    private void deleteCFunction() {
        Reference.pressedMessage(deleteCButton.getActionCommand());
    }

    private void createCFunction() {
        Reference.pressedMessage(createCButton.getActionCommand());
        createCollectionFrame.setVisible(true);
    }

    private void openSFunction() {
        Reference.pressedMessage(openSButton.getActionCommand());
    }

    private void deleteSFunction() {
        Reference.pressedMessage(deleteSButton.getActionCommand());
    }

    private void createSFunction() {
        Reference.pressedMessage(createSButton.getActionCommand());
    }

    private void openIFunction() {
        Reference.pressedMessage(openIButton.getActionCommand());
    }

    private void deleteIFunction() {
        Reference.pressedMessage(deleteIButton.getActionCommand());
    }

    private void createIFunction() {
        Reference.pressedMessage(createIButton.getActionCommand());
    }

    private void addImageFunction() {
        Reference.pressedMessage(addImageButton.getActionCommand());
    }

    // Function for events.
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("openc"))
            openCFunction();
        else if (e.getActionCommand().equals("delc"))
            deleteCFunction();
        else if (e.getActionCommand().equals("crec"))
            createCFunction();
        else if (e.getActionCommand().equals("opens"))
            openSFunction();
        else if (e.getActionCommand().equals("dels"))
            deleteSFunction();
        else if (e.getActionCommand().equals("cres"))
            createSFunction();
        else if (e.getActionCommand().equals("openi"))
            openIFunction();
        else if (e.getActionCommand().equals("deli"))
            deleteIFunction();
        else if (e.getActionCommand().equals("crei"))
            createIFunction();
        else if (e.getActionCommand().equals("addi"))
            addImageFunction();
    }
}
