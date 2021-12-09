package fr.anxxitty.jsu.UI;

import javax.swing.*;
import java.awt.*;

public class ModeSelector extends JPanel {

    JComboBox<String> modeComboBox;

    public ModeSelector() {
        super(new FlowLayout());
        this.modeComboBox = new JComboBox<>(new String[]{"Install", "Update"});
        this.add(new JLabel("Mode: "));
        this.add(modeComboBox);
    }

    public String getMode() {
        return (String) this.modeComboBox.getSelectedItem();
    }

}
