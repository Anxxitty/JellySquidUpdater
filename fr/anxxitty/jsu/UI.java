package fr.anxxitty.jsu;

import fr.anxxitty.jsu.install.Installer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Path;

public class UI extends JFrame {

    public UI() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("JellySquid Updater");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane content = new JTabbedPane();

        JPanel clientTab = new JPanel(new GridBagLayout());
        clientTab.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel serverTab = new JPanel(new GridBagLayout());
        serverTab.setBorder(new EmptyBorder(20, 20, 20, 20));



        //Client tab
        JPanel versionSelector = new JPanel(new FlowLayout());
        JPanel minecraftDirSelector = new JPanel(new FlowLayout());
        JPanel installPanel = new JPanel(new FlowLayout());

        JLabel versionText = new JLabel("Minecraft Version: ");
        JComboBox<String> versionComboBox = new JComboBox<>(new String[]{"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14"});
        versionSelector.add(versionText);
        versionSelector.add(versionComboBox);

        JLabel installDirText = new JLabel("Install Location: ");
        JTextField installDirInput = new JTextField("/home/anxxitty/.minecraft");  //TODO Automatically find .minecraft folder
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

        JButton installButton = new JButton("Install");
        installButton.addActionListener((e) -> Installer.installClient(Path.of(installDirInput.getText()), (String) versionComboBox.getSelectedItem()));
        installPanel.add(installButton);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        clientTab.add(versionSelector, gbc);
        gbc.gridy++;
        clientTab.add(minecraftDirSelector, gbc);
        gbc.gridy++;
        clientTab.add(installPanel, gbc);



        //Server tab
        serverTab.add(new JLabel("Lorem Ipsum Dolor"));



        content.addTab("Client", clientTab);
        content.addTab("Server", serverTab);

        this.add(content);
        this.pack();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.updateComponentTreeUI(this);
        this.setSize(425, 250);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
