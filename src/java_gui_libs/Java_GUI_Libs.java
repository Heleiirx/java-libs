/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package java_gui_libs;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/**
 *
 * @author pixel
 */
public class Java_GUI_Libs extends JFrame {
    public Java_GUI_Libs() {
        setTitle("Librerías GUI Java");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 400);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 1, 10, 10));

        JLabel title = new JLabel("Seleccione una Librería", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title);

        JButton btnJavaFX = new JButton("JavaFX");
        btnJavaFX.addActionListener((ActionEvent e) -> {
            new Thread(() -> WindowJavaFX.mostrarVentana()).start();
        });
        add(btnJavaFX);

        JButton btnSWT = new JButton("SWT");
        btnSWT.addActionListener(e -> {
            new Thread(() -> WindowSWT.mostrarVentana()).start();
        });
        add(btnSWT);

        JButton btnJGoodies = new JButton("JGoodies");
        btnJGoodies.addActionListener(e -> {
            new WindowJGoodies().setVisible(true);
        });
        add(btnJGoodies);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Java_GUI_Libs().setVisible(true));
    }
}
