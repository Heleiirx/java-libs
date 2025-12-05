/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package java_gui_libs;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author pixel
 */
public class WindowJavaFX extends Application {

    @Override
    public void start(Stage stage) {
        Label label = new Label("Ventana JavaFX");

        TextField textField = new TextField();
        textField.setPromptText("Escribe algo aquí...");

        Button button = new Button("Mostrar Mensaje");

        ComboBox<String> combo = new ComboBox<>();
        combo.getItems().addAll("Opción A", "Opción B", "Opción C");
        combo.setPromptText("Selecciona una opción");

        Slider slider = new Slider(0, 100, 50);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);

        button.setOnAction(e -> {
            String texto = textField.getText().isEmpty() ? "(vacío)" : textField.getText();
            String opcion = combo.getSelectionModel().getSelectedItem();
            double valorSlider = slider.getValue();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Datos ingresados");
            alert.setContentText(
                "Texto: " + texto +
                "\nOpción: " + (opcion == null ? "(ninguna)" : opcion) +
                "\nSlider: " + String.format("%.1f", valorSlider)
            );
            alert.show();
        });

        // ---- LAYOUT ----
        VBox root = new VBox(15, label, textField, combo, slider, button);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 350, 400);

        stage.setTitle("Ejemplo JavaFX");
        stage.setScene(scene);
        stage.show();
    }

    // ---- MÉTODO LLAMADO DESDE SWING ----
    public static void mostrarVentana() {
        Platform.startup(() -> {
            try {
                new WindowJavaFX().start(new Stage());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}