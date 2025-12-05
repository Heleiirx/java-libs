/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_gui_libs;
import javax.swing.*;
import com.jgoodies.forms.layout.*;
import com.jgoodies.forms.builder.PanelBuilder;
import com.jgoodies.forms.factories.Paddings;

/**
 *
 * @author pixel
 */
public class WindowJGoodies extends JFrame {

    public WindowJGoodies() {
        setTitle("Ejemplo JGoodies");
        setSize(350, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // ---- Layout con JGoodies ----
        FormLayout layout = new FormLayout(
            "pref, 10dlu, fill:pref:grow", 
            "pref, 10dlu, pref, 10dlu, pref, 10dlu, pref, 10dlu, pref"
        );

        PanelBuilder builder = new PanelBuilder(layout);
        builder.border(Paddings.DIALOG);

        CellConstraints cc = new CellConstraints();

        JLabel label = new JLabel("Ventana JGoodies");
        JTextField textField = new JTextField();
        JComboBox<String> combo = new JComboBox<>(new String[]{"A", "B", "C"});
        JSlider slider = new JSlider(0, 100, 40);
        JButton button = new JButton("Mostrar datos");

        builder.add(label, cc.xyw(1, 1, 3));
        builder.add(new JLabel("Texto:"), cc.xy(1, 3));
        builder.add(textField, cc.xy(3, 3));

        builder.add(new JLabel("Opción:"), cc.xy(1, 5));
        builder.add(combo, cc.xy(3, 5));

        builder.add(new JLabel("Slider:"), cc.xy(1, 7));
        builder.add(slider, cc.xy(3, 7));

        builder.add(button, cc.xyw(1, 9, 3));

        button.addActionListener(e -> {
            JOptionPane.showMessageDialog(
                this,
                "Texto: " + textField.getText() +
                "\nOpción: " + combo.getSelectedItem() +
                "\nSlider: " + slider.getValue(),
                "Datos",
                JOptionPane.INFORMATION_MESSAGE
            );
        });

        setContentPane(builder.getPanel());
    }
}