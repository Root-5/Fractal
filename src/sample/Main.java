package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Vector;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Group root = new Group();
        int gray = 0;
        double X0 = 3*1920/4; //абсцисса пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double Y0 = 1080/2;   //ордината пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double L = 320.0;    //длина отрезка, имеющего в новой системе координат единичную длину, выраженная в пикселях.
        for(int i = 0; i < 1920; ++i) {
            for (int j = 0; j < 1080; ++j) {
                double x = (i - X0) / L;
                double y = (j - Y0) / L;
                ComplexVariable z = new ComplexVariable(x, y);
                System.out.println("Hello from" + i + "and" + j);
                gray = ComplexVariable.getColor(z);
                if (gray != 255) {
                    Rectangle rectangle = new Rectangle(i, j, i, j);
                    rectangle.setFill(Color.rgb(gray, gray, gray));
                    //Circle circle = new Circle(i, j, 1);
                    root.getChildren().add(rectangle);
                }

            }
        }
        Scene scene = new Scene(root, 1920, 1080);
        primaryStage.setTitle("My app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
