package sample;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Renderer {
    public static void coordsDetect(int startX, int startY, int endX, int endY){

    }
    public static void render(Group root, EventHandler<MouseEvent> eventHandler, int startX, int endX, int startY, int endY){
        root.getChildren().removeAll();
        int width = 681, height = 681;
        int gray = 0;
        double X0 = 3*width/4; //абсцисса пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double Y0 = height/2;   //ордината пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double L = 320.0;    //длина отрезка, имеющего в новой системе координат единичную длину, выраженная в пикселях.
        for(double i = startX; i < endX; i += 0.5){
            for(double j = startY; j < endY; j += 0.5){
                double x = (i - X0) / L;
                double y = (j - Y0) / L;
                ComplexVariable z = new ComplexVariable(x, y);
                System.out.println("Loading: " + (((int)(((double)i)/width * 100) + 1)/2) + "%");
                gray = ComplexVariable.getColor(z);
                if(gray != 255) {
                    Rectangle rectangle = new Rectangle();
                    System.out.println("j= " + j + " and (int)j= "+ (int)j);
                    rectangle.setX(i*2 - startX*2);
                    rectangle.setY(j*2 - startY*2);
                    rectangle.setWidth(i*2 - startX*2);
                    rectangle.setHeight(j*2 - startY*2);
                    /*if(i > (int)i){
                        rectangle.setX((i/2 - startX)*2);
                        rectangle.setWidth((i/2 - startX)*2);
                        if(j/2 > (int)(j/2)) {
                            rectangle.setY((j / 2 - startY) * 2);
                            rectangle.setHeight((j / 2 - startY) * 2);
                        }
                        else {
                            rectangle.setY(j/2 - startY);
                            rectangle.setHeight(j/2-startY);
                        }
                    }
                    else {
                        rectangle.setX(i/2 - startX);
                        rectangle.setWidth(i/2 - startX);
                        if(j/2 > (int)(j/2)){
                            rectangle.setY((j / 2 - startY) * 2);
                            rectangle.setHeight((j / 2 - startY) * 2);
                        }
                        else{
                            rectangle.setY(j/2 - startY);
                            rectangle.setHeight(j/2-startY);
                        }

                        //Rectangle rectangle = new Rectangle(i/2 - startX, j/2 - startY, i/2 - startX, j/2-startY);
                    }*/
                    rectangle.setFill(Color.rgb(gray, 26, 190));
                    rectangle.addEventHandler(MouseEvent.MOUSE_PRESSED, eventHandler);
                    rectangle.addEventHandler(MouseEvent.MOUSE_RELEASED, eventHandler);
                    root.getChildren().add(rectangle);
                }
            }
        }
        /*for(int i = 0; i < width; ++i) {
            for (int j = 0; j < height; ++j) {
                double x = (i - X0) / L;
                double y = (j - Y0) / L;
                ComplexVariable z = new ComplexVariable(x, y);
                System.out.println("Loading: " + ((int)(((double)i)/width * 100) + 1) + "%");
                gray = ComplexVariable.getColor(z);
                if (gray != 255) {
                    Rectangle rectangle = new Rectangle(i, j, i, j);
                    rectangle.setFill(Color.rgb(gray, 26, 190));
                    rectangle.addEventHandler(MouseEvent.MOUSE_PRESSED, eventHandler);
                    rectangle.addEventHandler(MouseEvent.MOUSE_RELEASED, eventHandler);
                    root.getChildren().add(rectangle);
                }
            }
        }*/
    }
}
