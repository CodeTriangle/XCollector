package darthivan.apps.xcol.GUI.collection;

import darthivan.apps.xcol.Variables;

import javax.swing.*;
import javax.swing.plaf.metal.DefaultMetalTheme;
import javax.swing.plaf.metal.MetalLookAndFeel;
import java.awt.*;
import java.io.File;

public class CollectionFrame extends JFrame {

    public JPanel listPanel;
    public JPanel itemPanel;
    public JPanel buttonPanel;

    public String collectionArray[];
    public String seriesArray[];
    public String itemArray[];

    public JList<String> collectionList;
    public JList<String> seriesList;
    public JList<String> itemList;

    public JButton openButton;
    public JButton deleteButton;
    public JButton createButton;

    public CollectionFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super(title);
        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        collectionArray = new String[] {"Trading Cards", "Coins"};
        seriesArray = new String[] {"Canada", "Japan", "England", "Sweden"};
        itemArray = new String[] {"1900 Penny", "1987 Nickel", "2007 Quarter"};

        listPanel = new JPanel();
        itemPanel = new JPanel();
        buttonPanel = new JPanel();

        collectionList = new JList<String>(collectionArray);
        seriesList = new JList<String>(seriesArray);
        itemList = new JList<String>(itemArray);

        openButton = new JButton("Open");
        deleteButton = new JButton("Delete");
        createButton = new JButton("Create");

        collectionList.setFont(Variables.TNR);
        seriesList.setFont(Variables.TNR);
        itemList.setFont(Variables.TNR);

        openButton.setBackground(new Color(86, 209, 68));
        createButton.setBackground(new Color(49, 57, 209));
        deleteButton.setBackground(new Color(255, 85, 60));

        this.setLayout(new BorderLayout());
        listPanel.setLayout(new GridLayout(1, 3, 10, 10));
        itemPanel.setLayout(new BorderLayout());
        buttonPanel.setLayout(new FlowLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 600);
        this.setLocationRelativeTo(null);

        listPanel.add(collectionList);
        listPanel.add(seriesList);
        listPanel.add(itemList);

        buttonPanel.add(openButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(createButton);

        this.add(listPanel, BorderLayout.CENTER);
        this.add(buttonPanel, BorderLayout.SOUTH);
    }
}
