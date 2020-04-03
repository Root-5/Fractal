package sample;

public class MyMouse {
    public static int x;
    public static int y;
    public MyMouse(){
        x = 0;
        y = 0;
    }
    public static void setX(int x_){
        x = x_;
    }
    public static void setY(int y_){
        y = y_;
    }
    public static int getX(){
        return x;
    }
    public static int getY(){
        return y;
    }
}
