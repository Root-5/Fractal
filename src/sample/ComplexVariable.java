package sample;


import javafx.scene.paint.Color;

public class ComplexVariable {
    private double Re;
    private double Im;

    public ComplexVariable(){
        Re = 0;
        Im = 0;
    }

    public ComplexVariable(double RealPart, double ImaginePart){
        Re = RealPart;
        Im = ImaginePart;
    }

    public static ComplexVariable sum(ComplexVariable a, ComplexVariable b){
        ComplexVariable z = new ComplexVariable(a.Re + b.Re, a.Im + b.Im);
        return z;
    }

    public static ComplexVariable multiplication(ComplexVariable a, ComplexVariable b){
        ComplexVariable z = new ComplexVariable((a.Re*b.Re) - (b.Im * b.Im), a.Re*b.Im + a.Im * b.Re);
        return z;
    }

    public double getRealPart(){
        return this.Re;
    }

    public double getImaginePart(){
        return this.Im;
    }

    public static double complexAbsolutValue(ComplexVariable a){
        return (Math.sqrt(a.Re*a.Re + a.Im*a.Im));
    }

    //Интенсивность серого цвета
    public static int getColor(ComplexVariable z0){
        ComplexVariable z = new ComplexVariable(z0.Re, z0.Im);
        for(int i = 255; i>0; i--){
            if(complexAbsolutValue(z) > 2){
                return i;
            }
            z = sum(multiplication(z, z), z0);
        }

        return 0;
    }
}
