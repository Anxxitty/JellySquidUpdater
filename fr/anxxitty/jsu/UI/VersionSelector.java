package fr.anxxitty.jsu.UI;

import javax.swing.*;
import java.awt.*;

public class VersionSelector extends JPanel {

    JComboBox<String> versionSelector;

    public VersionSelector() {
        super(new FlowLayout());
        JLabel versionText = new JLabel("Minecraft Version: ");
        this.versionSelector= new JComboBox<>(new String[]{"1.17.1", "1.17", "1.16.5", "1.16.4", "1.16.3", "1.16.2", "1.16.1", "1.15.2", "1.15.1", "1.15", "1.14.4", "1.14.3", "1.14.2", "1.14.1", "1.14"});
        this.add(versionText);
        this.add(versionSelector);
    }

    public String getVersion() {
        return (String) this.versionSelector.getSelectedItem();
    }

}
