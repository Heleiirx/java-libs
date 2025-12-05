/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_gui_libs;
import org.eclipse.swt.*;
import org.eclipse.swt.widgets.*;
import org.eclipse.swt.layout.*;

/**
 *
 * @author pixel
 */
public class WindowSWT {

    public static void mostrarVentana() {
        Display display = new Display();
        Shell shell = new Shell(display);
        shell.setText("Ejemplo SWT");
        shell.setSize(350, 350);
        shell.setLayout(new GridLayout(1, false));

        Label label = new Label(shell, SWT.CENTER);
        label.setText("Ventana SWT");
        label.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Text text = new Text(shell, SWT.BORDER);
        text.setMessage("Escribe algo...");
        text.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Combo combo = new Combo(shell, SWT.DROP_DOWN | SWT.READ_ONLY);
        combo.setItems(new String[]{"Opción A", "Opción B", "Opción C"});
        combo.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Scale slider = new Scale(shell, SWT.HORIZONTAL);
        slider.setMinimum(0);
        slider.setMaximum(100);
        slider.setSelection(50);
        slider.setLayoutData(new GridData(SWT.FILL, SWT.CENTER, true, false));

        Button button = new Button(shell, SWT.PUSH);
        button.setText("Mostrar datos");
        button.setLayoutData(new GridData(SWT.CENTER, SWT.CENTER, true, false));

        button.addListener(SWT.Selection, e -> {
            MessageBox msg = new MessageBox(shell, SWT.OK);
            msg.setText("Datos");
            msg.setMessage(
                "Texto: " + text.getText() +
                "\nOpción: " + combo.getText() +
                "\nSlider: " + slider.getSelection()
            );
            msg.open();
        });

        shell.open();
        while (!shell.isDisposed()) {
            if (!display.readAndDispatch())
                display.sleep();
        }
        display.dispose();
    }
}
