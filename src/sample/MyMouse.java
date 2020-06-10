package sample;

public class MyMouse {
    //Where mouse was clicked;
    public static int x;
    public static int y;
    //Variables for saving data about coords for zoom
    public static int x_start = 0;
    public static int y_start = 0;
    public static int x_end;
    public static int y_end;
    public static int degree = 1;
    public static int x_previous_start = 0;
    public static int x_previous_end = 1024;
    public static int y_previous_start = 0;
    public static int y_previous_end = 1024;
    public static int for_zoom = 2;
    public static int count_of_clicked = 0;                 //For zoom
    public static boolean stage;  //Если менялась выделенная область мышки, то перерендерить
    public MyMouse(){
        x = 0;
        y = 0;
        stage = false;
        //count_of_clicked = 1;
    }
    public static void setX(int x_) { x = x_; }
    public static void setY(int y_){
        y = y_;
        stage = true;
    }
    public static int getX(){
        return x;
    }
    public static int getY(){
        stage = false;
        return y;
    }
    public static int pow(int a, int b)
    {
        int result = 1;
        for(int i = 0; i < b; ++i)
        {
            result *= a;
        }
        return result;
    }
}
