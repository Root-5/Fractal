package sample;

enum COLOR{
    Blue, Grey, Pink, Red, Green
}
//Class for save an information about one pixel
public class Dot {
    //coords of dot
    private double x;
    private double y;
    private COLOR color;
    private int intensityOfColor;
    //Constructors and Destructors;
    public Dot()
    {
        x = 0;
        y = 0;
        color = COLOR.Grey;
        intensityOfColor = 0;
    }
    public Dot(double x, double y, COLOR color, int intensityOfColor)
    {
        this.x = x;
        this.y = y;
        this.color = color;
        this.intensityOfColor = intensityOfColor;
    }
    //Setters
    public void setColor(COLOR color) {
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setIntensityOfColor(int intensityOfColor)
    {
        this.intensityOfColor = intensityOfColor;
    }
    //Getters
    public int getIntensityOfColor()
    {
        return intensityOfColor;
    }

    public double getX()
    {
        return x;
    }

    public double getY()
    {
        return y;
    }

    public COLOR getColor()
    {
        return color;
    }
}
