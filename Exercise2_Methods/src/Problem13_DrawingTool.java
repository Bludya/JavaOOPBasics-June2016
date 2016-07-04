import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * Created by Bludya on 30.6.2016 г..
 * All rights reserved!
 */
abstract class Figure{
    private int a;
    private int b;

    public Figure(int a, int b){
        this.a = a;
        this.b = b;
    }

    public String draw(){
        String drawing = "";

        drawing += "|";
        for (int i = 0; i < a; i++) {
            drawing+="-";
        }
        drawing += "|";
        drawing += "\n";

        for (int i = 0; i < b-2; i++) {
            drawing += "|";
            for (int j = 0; j < a; j++) {
                drawing+=" ";
            }
            drawing += "|";
            drawing += "\n";
        }

        drawing += "|";
        for (int i = 0; i < a; i++) {
            drawing+="-";
        }
        drawing += "|";
        drawing += "\n";

        return drawing;
    }
}

class Square extends Figure{
    public Square(int a){
        super(a, a);
    }
}

class Rectangle1 extends Figure{
    public Rectangle1(int a, int b){
        super(a, b);
    }
}

class CorDraw{
    Figure figure;

    public CorDraw(Figure figure){
        this.figure = figure;
    }

    public void draw(){
        System.out.println(figure.draw());
    }
}

public class Problem13_DrawingTool {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        CorDraw drawer;
        Figure figure;
        String figureName = reader.readLine();

        if("Square".equals(figureName)){
            int a = Integer.valueOf(reader.readLine());
            figure = new Square(a);
        }
        else if("Rectangle".equals(figureName)){
            int a = Integer.valueOf(reader.readLine());
            int b = Integer.valueOf(reader.readLine());
            figure = new Rectangle1(a,b);
        }
        else {
            return;
        }
        drawer = new CorDraw(figure);
        drawer.draw();
    }
}
