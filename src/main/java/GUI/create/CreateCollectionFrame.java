package GUI.create;

import main.Reference;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class CreateCollectionFrame extends JFrame implements ActionListener {
    JTextField titleField;

    JButton okButton;
    JButton cancelButton;

    JPanel buttonPanel;

    public CreateCollectionFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel"); // Set look and feel to ♥Nimbus♥

        titleField = new JTextField(""); // Place where you type the title of the collection in.

        // OK and Cancel buttons.
        okButton = new JButton("OK", Reference.checkIcon);
        cancelButton = new JButton("Cancel", Reference.cancelIcon);

        // Panel for the buttons.
        buttonPanel = new JPanel();

        // Set this window's layout to GridBagLayout.
        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        // Set window properties.
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        //  Add stuff.
        buttonPanel.add(okButton);
        buttonPanel.add(cancelButton);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        this.add(new JLabel("Type Name here: "), c);

        c.weightx = 1.0;
        c.gridx = 1;
        c.gridwidth = 2;
        this.add(titleField, c);

        c.weightx = 1.0;
        c.gridx = 0;
        c.gridy = 1;
        c.gridwidth = 3;
        this.add(buttonPanel, c);

        // Window property stuff.
        this.pack();
        this.setSize(500, this.getHeight());
        this.setLocationRelativeTo(null);

        // Add action listener.
        okButton.addActionListener(this);
        cancelButton.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("OK")) {
            if (!new File(Reference.DATA_DIR + "\\" + titleField.getText()).exists()) {
                new File(Reference.DATA_DIR + "\\" + titleField.getText()).mkdir();
                System.out.print("\"" + titleField.getText() + "\" collection created.");
                this.setVisible(false);
            }
            else System.out.print("Collection already exists. Please retry.");
        }
        else if (e.getActionCommand().equals("Cancel"))
            this.setVisible(false);
            Reference.closedMessage("CreateCollectionFrame");
    }
}
