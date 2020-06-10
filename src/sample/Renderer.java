package sample;

import javafx.event.EventHandler;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.PixelWriter;
import javafx.scene.input.MouseEvent;
import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;

import java.util.Iterator;

public class Renderer {
    //public static int wasPressed = 0;
    public static void render(GraphicsContext gc, Pixels pixels, int startX, int endX, int startY, int endY, double zoom){
        //gc.clearRect(0, 0, 680, 680);
        pixels.clear();
        double zooming = 1/zoom;
        int width = 1024, height = 1024;
        int gray = 0;
        double X0 = 3*width/4; //абсцисса пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double Y0 = height/2;   //ордината пикселя в исходной системе координат, в который помещено начало новой системы координат;
        double L = 500.0;    //длина отрезка, имеющего в новой системе координат единичную длину, выраженная в пикселях.
        for(double i = startX; i < endX; i += zooming){
            for(double j = startY; j < endY; j += zooming){
                double x = (i - X0) / L;
                //double x = i / L;
                double y = (j - Y0) / L;
                //double y = j / L;
                ComplexVariable z = new ComplexVariable(x, y);
                //System.out.println("Loading: " + (((int)(((double)i)/width * 100) + 1)/zoom) + "%");
                gray = ComplexVariable.getColor(z);
                Dot dot = new Dot(i*zoom - startX*zoom, j*zoom - startY*zoom, COLOR.Grey, gray );
                pixels.add(dot);
                //System.out.println("j= " + j + " and (int)j= "+ (int)j);
            }
        }
    }

    public static void draw(PixelWriter pixelWriter, Pixels pixels, int color_)
    {
        //System.out.println(pixels.get(160000).getIntensityOfColor());
        for(int i = 0; i < pixels.size(); ++i)
        {
            if(color_ == 1)
            {
                int gray = pixels.get(i).getIntensityOfColor();
                Color color = Color.rgb(gray, gray, gray);
                pixelWriter.setColor((int)pixels.get(i).getX(), (int)pixels.get(i).getY(), color);
            }
            else {
                int gray = pixels.get(i).getIntensityOfColor();
                if(gray > 25)
                {
                    Color color = Color.rgb(gray, 0, 0);
                    pixelWriter.setColor((int) pixels.get(i).getX(), (int) pixels.get(i).getY(), color);
                }
                System.out.println(i/462400);
            }
        }
    }
    //function for calculating the startX, endX, startY, endY for zooming
    public static void setToZoom(int width, int height)
    {
        if(MyMouse.count_of_clicked > 0)
        {
            MyMouse.x_previous_start = MyMouse.x_start;
            MyMouse.y_previous_start = MyMouse.y_start;
            MyMouse.x_previous_end = MyMouse.x_end;
            MyMouse.y_previous_end = MyMouse.y_end;
        }
        MyMouse.count_of_clicked++;
        double lengthOfField = MyMouse.x_end - MyMouse.x_start;
        if(MyMouse.count_of_clicked > 0)
        {
            MyMouse.x_previous_start = MyMouse.x_start;
            MyMouse.y_previous_start = MyMouse.y_start;
            MyMouse.x_previous_end = MyMouse.x_end;
            MyMouse.y_previous_end = MyMouse.y_end;
        }
        MyMouse.count_of_clicked++;
        //MyMouse.x = MyMouse.x/MyMouse.for_zoom + MyMouse.x_previous_start;
        //MyMouse.y = MyMouse.y/MyMouse.for_zoom + MyMouse.y_previous_start;
        if(MyMouse.x < (double)width/(2*MyMouse.for_zoom) || MyMouse.y < (double)height/(2*MyMouse.for_zoom) || MyMouse.x + (double)width/(2*MyMouse.for_zoom) > width || MyMouse.y + (double)height/(2*MyMouse.for_zoom) > height)
        {
            //Если x меньше или больше предполагаемых рамок
            if(MyMouse.x < (double)width/(2*MyMouse.for_zoom) || MyMouse.x + (double)width/(2*MyMouse.for_zoom) > width)
            {
                if(MyMouse.x < (double)width/(2*MyMouse.for_zoom))
                {
                    MyMouse.x_start = 0;
                    MyMouse.x_end = width/MyMouse.for_zoom;
                }
                if(MyMouse.x + (double)width/(2*MyMouse.for_zoom) > width)
                {
                    MyMouse.x_start = width/MyMouse.for_zoom;
                    MyMouse.x_end = width;
                }
            }
            else
            {
                MyMouse.x_start = MyMouse.x - width/(2*MyMouse.for_zoom);
                MyMouse.x_end = MyMouse.x + width/(2*MyMouse.for_zoom);
            }
            //Если y меньше или больше предполагаемых рамок
            if(MyMouse.y < (double)height/(2*MyMouse.for_zoom) || MyMouse.y + (double)height/(2*MyMouse.for_zoom) > height)
            {
                if(MyMouse.y - (double)height/(2*MyMouse.for_zoom) < 0)
                {
                    MyMouse.y_start = 0;
                    MyMouse.y_end = height/MyMouse.for_zoom;
                }
                if(MyMouse.y + (double)height/(2*MyMouse.for_zoom) > height)
                {
                    MyMouse.y_start = height/MyMouse.for_zoom;
                    MyMouse.y_end = height;
                }
            }
            else
            {
                MyMouse.y_start = MyMouse.y - height/(2*MyMouse.for_zoom);
                MyMouse.y_end = MyMouse.y + height/(2*MyMouse.for_zoom);
            }
        }
        else
        {
            MyMouse.x_start = MyMouse.x - width/(2*MyMouse.for_zoom);
            MyMouse.x_end = MyMouse.x + width/(2*MyMouse.for_zoom);
            MyMouse.y_start = MyMouse.y - height/(2*MyMouse.for_zoom);
            MyMouse.y_end = MyMouse.y + height/(2*MyMouse.for_zoom);
        }
    }
    public static void func()
    {
        int shift = (int)(1024/MyMouse.for_zoom);
        MyMouse.x_start = MyMouse.x_start - MyMouse.for_zoom * shift / 2;
        MyMouse.x_end = MyMouse.x_end - MyMouse.for_zoom * shift / 2;
        MyMouse.y_start = MyMouse.y_start - MyMouse.for_zoom * shift / 2;
        MyMouse.y_end = MyMouse.y_end - MyMouse.for_zoom * shift / 2;
    }
}

