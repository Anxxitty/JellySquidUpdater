package fr.anxxitty.jsu.UI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class InstallPanel extends JPanel {

    public InstallPanel(ActionListener e) {
        super(new FlowLayout());
        JButton installButton = new JButton("Install");
        installButton.addActionListener(e);
        this.add(installButton);
    }

}
