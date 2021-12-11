package fr.anxxitty.jsu;

import fr.anxxitty.jsu.UI.InstallPanel;
import fr.anxxitty.jsu.UI.MinecraftDirSelector;
import fr.anxxitty.jsu.UI.ModeSelector;
import fr.anxxitty.jsu.UI.VersionSelector;
import fr.anxxitty.jsu.install.Installer;
import fr.anxxitty.jsu.install.Updater;
import fr.anxxitty.jsu.util.Utils;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.io.File;

public class Display extends JFrame {

    ModeSelector clientModeSelector;
    VersionSelector clientVersionSelector;
    MinecraftDirSelector clientMinecraftDirSelector;
    InstallPanel clientInstallPanel;
    JCheckBox profileCheckBox;

    ModeSelector serverModeSelector;
    VersionSelector serverVersionSelector;
    MinecraftDirSelector serverMinecraftDirSelector;
    InstallPanel serverInstallPanel;
    JCheckBox generateScriptsCheckBox;

    public Display() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        super("JellySquid Updater");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane content = new JTabbedPane();

        JPanel clientTab = new JPanel(new GridBagLayout());
        clientTab.setBorder(new EmptyBorder(20, 20, 20, 20));

        JPanel serverTab = new JPanel(new GridBagLayout());
        serverTab.setBorder(new EmptyBorder(20, 20, 20, 20));



        //Client tab
        this.clientModeSelector = new ModeSelector();
        this.clientVersionSelector = new VersionSelector();
        this.clientMinecraftDirSelector = new MinecraftDirSelector("Minecraft Launcher Folder: ", Utils.findMinecraftDir());
        this.clientInstallPanel = new InstallPanel((e) -> this.selectInstallMode(0));
        this.profileCheckBox = new JCheckBox("Create Profile");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridy = 0;
        clientTab.add(clientModeSelector, gbc);
        gbc.gridy++;
        clientTab.add(clientVersionSelector, gbc);
        gbc.gridy++;
        clientTab.add(clientMinecraftDirSelector, gbc);
        gbc.gridy++;
        clientTab.add(profileCheckBox, gbc);
        gbc.gridy++;
        clientTab.add(clientInstallPanel, gbc);



        //Server tab
        this.serverModeSelector = new ModeSelector();
        this.serverVersionSelector = new VersionSelector();
        this.serverMinecraftDirSelector = new MinecraftDirSelector("Server Folder: ", Utils.getHomeFolder());
        this.serverInstallPanel = new InstallPanel((e) -> this.selectInstallMode(1));
        this.generateScriptsCheckBox = new JCheckBox("Generate Launch Scripts");

        gbc.gridy = 0;
        serverTab.add(serverModeSelector, gbc);
        gbc.gridy++;
        serverTab.add(serverVersionSelector, gbc);
        gbc.gridy++;
        serverTab.add(serverMinecraftDirSelector, gbc);
        gbc.gridy++;
        serverTab.add(generateScriptsCheckBox, gbc);
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

    private void selectInstallMode(int clientOrServer) {
        if (clientOrServer == 1) {
            if (this.serverModeSelector.getMode().equalsIgnoreCase("install")) {
                Installer.installServer(new File(this.serverMinecraftDirSelector.getInstallDir()), serverVersionSelector.getVersion(), this.generateScriptsCheckBox.isSelected());
            }
            else {
                Updater.updateServer(new File(this.serverMinecraftDirSelector.getInstallDir()), serverVersionSelector.getVersion());
            }
        } else {
            if (this.clientModeSelector.getMode().equalsIgnoreCase("install")) {
                Installer.installClient(new File(this.clientMinecraftDirSelector.getInstallDir()), clientVersionSelector.getVersion(), this.profileCheckBox.isSelected());
            }
            else {
                Updater.updateClient(new File(this.clientMinecraftDirSelector.getInstallDir()), clientVersionSelector.getVersion());
            }
        }
    }

}
