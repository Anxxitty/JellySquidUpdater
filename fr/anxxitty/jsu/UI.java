package fr.anxxitty.jsu;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Path;

public class UI extends JFrame {

    public static JComboBox<String> versionComboBox;
    public static JTextField installDirInput;

    public UI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("JellySquid Updater");
        this.setSize(849, 480);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

        JPanel content = new JPanel(new GridBagLayout());
        content.setBorder(new EmptyBorder(20, 20, 20, 20));
        this.setContentPane(content);

        JPanel versionSelector = new JPanel(new FlowLayout());
        JPanel minecraftDirSelector = new JPanel(new FlowLayout());
        JPanel installPanel = new JPanel(new FlowLayout());

        JLabel versionText = new JLabel("Minecraft Version: ");
        versionComboBox = new JComboBox<>(new String[]{"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14"});
        versionSelector.add(versionText);
        versionSelector.add(versionComboBox);

        JLabel installDirText = new JLabel("Install Location: ");
        installDirInput = new JTextField("/home/anxxitty/.minecraft");  //TODO Automatically find .minecraft folder
        JButton fileExplorerButton = new JButton("...");
        fileExplorerButton.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser(installDirInput.getText());
            fileChooser.setDialogTitle("Select Install Location");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
        });
        minecraftDirSelector.add(installDirText);
        minecraftDirSelector.add(installDirInput);
        minecraftDirSelector.add(fileExplorerButton);

        JButton installButton = new JButton("install");
        installButton.addActionListener((e) -> this.installClient(Path.of(installDirInput.getText()), (String) versionComboBox.getSelectedItem()));
        installPanel.add(installButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        this.add(versionSelector, gbc);
        gbc.gridy++;
        this.add(minecraftDirSelector, gbc);
        gbc.gridy++;
        this.add(installPanel, gbc);
        this.pack();
        this.setVisible(true);
    }

    private void installClient(Path installLocation, String version) {
        System.out.println(installLocation + " " + version);
    }

}
