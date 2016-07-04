import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Bludya on 29.6.2016 г..
 * All rights reserved!
 */
class Coordinate{
    private double x;
    private double y;
    public Coordinate(double x, double y){
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}
class Rectangle{
    private String id;
    private double width;
    private double height;
    private Coordinate coordinates;

    public Rectangle(String id, double width, double height, Coordinate coordinate){
        this.id = id;
        this.width = width;
        this.height = height;
        this.coordinates = coordinate;
    }

    public double getHeight() {
        return height;
    }

    public Coordinate getCoordinates() {
        return coordinates;
    }

    public double getWidth() {
        return width;
    }

    public boolean checkIntersection(Rectangle rectangle){
        return this.coordinates.getX() + width >= rectangle.getCoordinates().getX() &&
                this.coordinates.getX() <= rectangle.getCoordinates().getX() + rectangle.getWidth() &&
                this.coordinates.getY() >= rectangle.getCoordinates().getY() - rectangle.getHeight() &&
                this.coordinates.getY() - width <= rectangle.getCoordinates().getY();
    }


}
public class Problem11_RectangleIntersection {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Map<String, Rectangle> rectangles = new HashMap<>();

        String[] numbers = reader.readLine().split("\\s+");
        int n = Integer.valueOf(numbers[0]);
        int m = Integer.valueOf(numbers[1]);

        for (int i = 0; i < n; i++) {
            String[] rectInfo = reader.readLine().split("\\s+");
            String id = rectInfo[0];
            double width = Double.valueOf(rectInfo[1]);
            double height = Double.valueOf(rectInfo[2]);
            double x = Double.valueOf(rectInfo[3]);
            double y = Double.valueOf(rectInfo[4]);
            Rectangle rectangle = new Rectangle(id, width, height, new Coordinate(x,y));
            rectangles.put(id, rectangle);
        }

        for (int i = 0; i < m; i++) {
            String[] check = reader.readLine().split("\\s+");
            String rect1 = check[0];
            String rect2 = check[1];

            System.out.println(rectangles.get(rect1).checkIntersection(rectangles.get(rect2)));
        }


    }
}
