package darthivan.apps.xcol.GUI.collection;

import darthivan.apps.xcol.GUI.create.CreateThingFrame;
import darthivan.apps.xcol.GUI.open.ImagePanel;
import darthivan.apps.xcol.Variables;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class CollectionFrame extends JFrame implements ActionListener {

    public JFrame createFrame;

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

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        collectionArray = new String[] {"Trading Cards", "Coins"};
        seriesArray = new String[] {"Canada", "Japan", "England", "Sweden"};
        itemArray = new String[] {"1900 Penny", "1987 Nickel", "2007 Quarter"};

        createFrame = new CreateThingFrame("Create What?");

        listPanel = new JPanel();
        itemButtonPanel = new JPanel();
        itemPanel = new JPanel();
        buttonPanel = new JPanel();
        imagePanel = new SquareImagePanel(Variables.PLACEHOLDER_FILE, SquareImagePanel.TALL);
        detailsPanel = new JPanel();

        collectionList = new JList<String>(collectionArray);
        seriesList = new JList<String>(seriesArray);
        itemList = new JList<String>(itemArray);

        openButton = new JButton("Open");
        deleteButton = new JButton("Delete");
        createButton = new JButton("Create");

        titleField = new JTextField("1900 Penny");
        descriptionArea = new JTextArea("I bought this from a shady street vendor in 2000. He sold me this for 5 " +
                "dollars. Said it was a rare coin. I trusted him.");

        collectedBox = new JCheckBox("Collected?", false);

        line = BorderFactory.createLineBorder(new Color(105, 105, 105));

        collectionList.setFont(Variables.TNR);
        seriesList.setFont(Variables.TNR);
        itemList.setFont(Variables.TNR);

        titleField.setFont(Variables.TNR_LARGE);

        collectionList.setBackground(new Color(135, 135, 135));
        seriesList.setBackground(new Color(155, 155, 155));
        itemList.setBackground(new Color(175, 175, 175));

        collectionList.setForeground(new Color(235, 235, 235));
        seriesList.setForeground(new Color(245, 245, 245));
        itemList.setForeground(new Color(255, 255, 255));

        openButton.setBackground(new Color(0, 200, 0));
        createButton.setBackground(new Color(0, 0, 200));
        deleteButton.setBackground(new Color(240, 0, 0));

        titleField.setBackground(new Color(156, 156, 156));
        titleField.setForeground(new Color(255,255,255));

        descriptionArea.setBackground(new Color(155, 155, 155));
        descriptionArea.setForeground(new Color(255,255,255));

        collectionList.setBorder(line);
        seriesList.setBorder(line);
        itemList.setBorder(line);

        titleField.setBorder(line);
        descriptionArea.setBorder(line);

        this.setLayout(new GridLayout(2,1));
        itemButtonPanel.setLayout(new BorderLayout());
        listPanel.setLayout(new GridLayout(1, 5, 10, 10));
        itemPanel.setLayout(new GridLayout());
        buttonPanel.setLayout(new FlowLayout());
        detailsPanel.setLayout(new BorderLayout(10, 10));

        descriptionArea.setLineWrap(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

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

        this.add(listPanel, BorderLayout.CENTER);
        this.add(itemButtonPanel, BorderLayout.SOUTH);

        openButton.addActionListener(this);
        deleteButton.addActionListener(this);
        createButton.addActionListener(this);
    }

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
