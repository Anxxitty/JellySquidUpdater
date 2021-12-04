package fr.anxxitty.jsu.UI;

import javax.swing.*;
import java.awt.*;

public class MinecraftDirSelector extends JPanel {

    JLabel installDirText;
    JTextField installDirInput;
    JButton fileExplorerButton;

    public MinecraftDirSelector(String msg) {
        super(new FlowLayout());
        this.installDirText = new JLabel(msg);
        this.installDirInput = new JTextField("/home/anxxitty/.minecraft");  //TODO Automatically find .minecraft folder
        this.fileExplorerButton = new JButton("...");
        this.fileExplorerButton.addActionListener((e) -> {
            JFileChooser fileChooser = new JFileChooser(installDirInput.getText());
            fileChooser.setDialogTitle("Select Install Location");
            fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            fileChooser.showOpenDialog(this);
        });
        this.add(installDirText);
        this.add(installDirInput);
        this.add(fileExplorerButton);
    }

    public String getInstallDir() {
        return this.installDirInput.getText();
    }

}
