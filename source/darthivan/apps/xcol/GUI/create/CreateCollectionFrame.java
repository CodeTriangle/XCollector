package darthivan.apps.xcol.GUI.create;

import com.sun.org.apache.bcel.internal.generic.FLOAD;
import darthivan.apps.xcol.GUI.BlankLabel;
import darthivan.apps.xcol.Variables;

import javax.swing.*;
import java.awt.*;

public class CreateCollectionFrame extends JFrame {
    JTextField titleField;

    JButton okButton;
    JButton cancelButton;

    public CreateCollectionFrame(String title) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        super(title);

        UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");

        titleField = new JTextField("");

        okButton = new JButton("OK");
        cancelButton = new JButton("Cancel");

        this.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        okButton.setBackground(new Color(0, 200, 0));
        cancelButton.setBackground(new Color(240, 0, 0));

        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.0;
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        this.add(new JLabel("Type Collection Name here:"), c);

        c.weightx = 1.0;
        c.gridx = 1;
        c.gridwidth = 4;
        this.add(titleField, c);

        c.weightx = 0.0;
        c.gridx = 2;
        c.gridy = 1;
        c.gridwidth = 1;
        this.add(okButton, c);

        c.weightx = 0.0;
        c.gridx = 3;
        this.add(cancelButton, c);

        this.pack();
        this.setSize(500, this.getHeight());
        this.setLocationRelativeTo(null);
    }
}
