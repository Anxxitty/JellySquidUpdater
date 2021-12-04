package fr.anxxitty.jsu;

import fr.anxxitty.jsu.UI.InstallPanel;
import fr.anxxitty.jsu.UI.MinecraftDirSelector;
import fr.anxxitty.jsu.UI.VersionSelector;
import fr.anxxitty.jsu.install.Installer;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.nio.file.Path;

public class Display extends JFrame {

    public Display() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("JellySquid Updater");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane content = new JTabbedPane();

        JPanel clientTab = new JPanel(new GridBagLayout());
        clientTab.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel serverTab = new JPanel(new GridBagLayout());
        serverTab.setBorder(new EmptyBorder(20, 20, 20, 20));



        //Client tab
        VersionSelector clientVersionSelector = new VersionSelector();
        MinecraftDirSelector clientMinecraftDirSelector = new MinecraftDirSelector("Minecraft Launcher Folder: ");
        InstallPanel clientInstallPanel = new InstallPanel((e) -> Installer.installClient(Path.of(clientMinecraftDirSelector.getInstallDir()), clientVersionSelector.getVersion()));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        clientTab.add(clientVersionSelector, gbc);
        gbc.gridy++;
        clientTab.add(clientMinecraftDirSelector, gbc);
        gbc.gridy++;
        clientTab.add(clientInstallPanel, gbc);



        //Server tab
        VersionSelector serverVersionSelector = new VersionSelector();
        MinecraftDirSelector serverMinecraftDirSelector = new MinecraftDirSelector("Server Folder: ");
        InstallPanel serverInstallPanel = new InstallPanel((e) -> Installer.installClient(Path.of(clientMinecraftDirSelector.getInstallDir()), clientVersionSelector.getVersion()));

        gbc.gridy = 0;
        serverTab.add(serverVersionSelector, gbc);
        gbc.gridy++;
        serverTab.add(serverMinecraftDirSelector, gbc);
        gbc.gridy++;
        serverTab.add(serverInstallPanel, gbc);


        content.addTab("Client", clientTab);
        content.addTab("Server", serverTab);

        this.add(content);
        this.pack();
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        SwingUtilities.updateComponentTreeUI(this);
        this.setSize(525, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
