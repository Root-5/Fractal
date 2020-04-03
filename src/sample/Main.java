package sample;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
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
        //MouseEvent mouseX;
        int startX = 0;
        int startY = 0;
        int width = 680, height = 680;
        Group root = new Group();
        int x = 0;
        EventHandler<MouseEvent> eventHandler = new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if(mouseEvent.getEventType() == MouseEvent.MOUSE_PRESSED){
                    System.out.println("Hello, Dima at coords: x:" + mouseEvent.getSceneX() + " and y:" + mouseEvent.getScreenY()
                    );
                    MyMouse.setX((int)mouseEvent.getSceneX());
                    MyMouse.setY((int)mouseEvent.getSceneY());
                }
                if(mouseEvent.getEventType() == MouseEvent.MOUSE_RELEASED){
                    System.out.println("goodbye, Dima at coords: x:" + mouseEvent.getSceneX() + " and y:" + mouseEvent.getScreenY());
                }
            }
        };
        while(MyMouse.getX() <500){
            Renderer.render(root, eventHandler, MyMouse.getX(), MyMouse.getX() + width/2, MyMouse.getY(),
                    MyMouse.getY() + height/2);
            Scene scene = new Scene(root, width, height);
            primaryStage.setScene(scene);
            primaryStage.setTitle("Dima's app");
            primaryStage.show();
        }
        System.out.println("Enter an coords");
        //int startX = Reader.scan();
        //int startY = Reader.scan();

        //Renderer.render(root, eventHandler, startX, 340 ,startY,340);
        //Scene scene = new Scene(root, width, height);
        //System.out.println("Hehehe");
        //Thread.sleep(10000);
        //System.out.println("Hello from thread");

    }


    public static void main(String[] args) {
        launch(args);
    }
}
