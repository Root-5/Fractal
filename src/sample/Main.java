package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Path;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import javax.sound.midi.SysexMessage;
import java.util.Vector;

import java.util.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        int width = 1024, height = 1024;
        Pixels pixels = new Pixels();
        FlowPane root = new FlowPane();
        GraphicsContext graphicsContext;
        Canvas canvas = new Canvas(width, height);
        graphicsContext = canvas.getGraphicsContext2D();
        PixelWriter pixelWriter = canvas.getGraphicsContext2D().getPixelWriter();
        root.setAlignment(Pos.BOTTOM_CENTER);
        root.getChildren().add(canvas);
        Renderer.render(graphicsContext, pixels,  0, width, 0, height, 1);
        Renderer.draw(pixelWriter, pixels, 1);
        //Button button = new Button("Change Color");
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent)
            {
                System.out.println("Hello from handle func");
                if(mouseEvent.getEventType() == MouseEvent.MOUSE_CLICKED)
                {
                    System.out.println("CLICKED");
                    //Получаем координаты нажатия, сохраняем в MyMouse
                    MyMouse.setX((int)mouseEvent.getX());
                    MyMouse.setY((int)mouseEvent.getY());
                    //Увеличиваем переменную for_zoom, чтобы понять, насколько приближать
                    MyMouse.for_zoom = MyMouse.pow(2, MyMouse.degree);
                    MyMouse.degree++;
                    System.out.println("For zoom = " + MyMouse.for_zoom);
                    System.out.println(MyMouse.x + " " + MyMouse.y);
                    Renderer.setToZoom(width, height);
                    if(MyMouse.count_of_clicked > 1)
                    {
                        Renderer.render(graphicsContext, pixels, MyMouse.x_start, MyMouse.x_end, MyMouse.y_start, MyMouse.y_end, MyMouse.for_zoom);
                        //Renderer.func();
                    }
                    else {
                        Renderer.render(graphicsContext, pixels, MyMouse.x_start, MyMouse.x_end, MyMouse.y_start, MyMouse.y_end, MyMouse.for_zoom);
                    }
                    System.out.println("Start x = " + MyMouse.x_start + "; End x = " + MyMouse.x_end + "; Start y = " + MyMouse.y_start + "; End y = " + MyMouse.y_end);
                    //Renderer.render(graphicsContext, pixels, MyMouse.x_start, MyMouse.x_end, MyMouse.y_start, MyMouse.y_end, MyMouse.for_zoom);
                    Renderer.draw(pixelWriter, pixels, 1);
                }
            }
        };
        canvas.setOnMouseClicked(eventHandler);
        
        Scene scene = new Scene(root, width, height);
        primaryStage.setTitle("My app");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
