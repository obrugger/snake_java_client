package GUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Oscar on 26-10-2015.
 */
public class Menu extends JPanel{

    private JComboBox<String> comboBox;

    public Menu(){

        setLayout(null);
        comboBox = new JComboBox();
        comboBox.setBounds(210, 105, 264, 44);
        add(comboBox);
        comboBox.setBackground(Color.WHITE);

    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }
}
