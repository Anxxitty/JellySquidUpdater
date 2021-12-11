package fr.anxxitty.jsu.UI;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class MinecraftDirSelector extends JPanel {

    JLabel installDirText;
    JTextField installDirInput;
    JButton fileExplorerButton;

    public MinecraftDirSelector(String msg, String dir) {
        super(new FlowLayout());
        this.installDirText = new JLabel(msg);
        this.installDirInput = new JTextField(dir);
        this.fileExplorerButton = new JButton("...");
        this.fileExplorerButton.addActionListener(e -> selectInstallLocation(() -> installDirInput.getText(), s -> installDirInput.setText(s)));
        this.add(installDirText);
        this.add(installDirInput);
        this.add(fileExplorerButton);
    }

    public String getInstallDir() {
        return this.installDirInput.getText();
    }

    private static void selectInstallLocation(Supplier<String> initalDir, Consumer<String> selectedDir) {
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File(initalDir.get()));
        chooser.setDialogTitle("Select Install Directory");
        chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);

        if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            selectedDir.accept(chooser.getSelectedFile().getAbsolutePath());
        }
    }

}
