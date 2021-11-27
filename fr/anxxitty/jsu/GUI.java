package fr.anxxitty.jsu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI extends JFrame {

    public static final Color LIGHT_GRAY = new Color(90, 90, 90);
    public static final Color GRAY = new Color(65, 65, 65);
    public static final Color DARK_GRAY = new Color(40, 40, 40);

    public static JComboBox<String> versionComboBox;

    public GUI() {
        super("JellySquid Updater");
        this.setSize(849, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setBackground(GRAY);

        JPanel versionSelector = new JPanel(new FlowLayout());
        JPanel minecraftDirSelector = new JPanel(new FlowLayout());
        JPanel installPanel = new JPanel(new FlowLayout());

        JLabel versionText = new JLabel("Minecraft Version: ");
        versionComboBox = new JComboBox<>(new String[]{"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14"});
        versionSelector.add(versionText);
        versionSelector.add(versionComboBox);

        JButton installButton = new JButton("install");
        installButton.addActionListener(new ButtonListener());
        installPanel.add(installButton);

        JLabel installDirText = new JLabel("Install Location: ");
        JTextArea installDirInput = new JTextArea("lorem ipsum dolor");
        minecraftDirSelector.add(installDirText);
        minecraftDirSelector.add(installDirInput);

        this.add(versionSelector, BorderLayout.PAGE_START);
        this.add(minecraftDirSelector, BorderLayout.CENTER);
        this.add(installPanel, BorderLayout.PAGE_END);
        this.setVisible(true);
    }

    private static class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            System.out.println(GUI.versionComboBox.getSelectedItem());
        }
    }

}
