package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Gui extends Application {
    private TextField tfFirstValue = new TextField();
    private TextField tfSecondValue = new TextField();
    private Button btConvert = new Button("Convert");

    @Override
    public void start(Stage stage) {
        GridPane gridPane = new GridPane();
        gridPane.setVgap(5);
        gridPane.setHgap(5);
        gridPane.add(new Label("Enter input like so: 5 lb = oz\n m -> cm and mm \n lb -> oz \n km -> m"), 0, 0);
        gridPane.add(tfFirstValue, 3, 0);
        gridPane.add(new Label("Conversion"), 0, 1);
        gridPane.add(tfSecondValue, 3, 1);
        gridPane.add(btConvert, 3, 2);

        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        btConvert.setOnMouseClicked(event -> {
            String input = tfFirstValue.getText();
            String[] strArray;
            strArray = input.split(" ");
            float sourceNum = Float.parseFloat(strArray[0]);
            String sourceMetric = strArray[1];
            String targetMetric = strArray[3];
            metricConverter(sourceMetric, targetMetric, sourceNum, tfSecondValue);

        });

        Scene scene = new Scene(gridPane);
        stage.setTitle("Metric Converter");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String args[]) {
        launch(args);
    }

    public static float metricConverter(String sourceMetric, String targetMetric, float sourceNum, TextField tf) {
        float targetNum = 0;
        switch (sourceMetric) {
            case "m":
                switch (targetMetric) {
                    case "cm":
                        targetNum = sourceNum * 100;
                        tf.setText(
                                String.format("%.1f %s = %.1f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));

                        break;

                    case "mm":
                        targetNum = sourceNum * 1000;
                        tf.setText(
                                String.format("%.1f %s = %.1f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                        break;

                }
                break;

            case "km":
                switch (targetMetric) {
                    case "m":
                        targetNum = sourceNum * 1000;
                        tf.setText(
                                String.format("%.1f %s = %.1f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                        break;

                }
                break;

            case "lb":
                switch (targetMetric) {
                    case "oz":
                        targetNum = sourceNum * 16;
                        tf.setText(
                                String.format("%.1f %s = %.1f %s%n", sourceNum, sourceMetric, targetNum, targetMetric));
                        break;

                }
                break;

        }

        return targetNum;
    }
}
