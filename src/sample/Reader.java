package sample;
import java.util.Scanner;


public class Reader {
    public static int scan(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        in.close();
        return num;
    }
}
