package sixth;

public class Paint 
{
    public static void main(String[] args) {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(1, 1);
        Point point3 = new Point(2, 2);

        Circle circle = new Circle(point1, 5.0);
        Rectangle rectangle = new Rectangle(point2, 4.0, 3.0);
        Square square = new Square(point3, 2.5);
        Triangle triangle = new Triangle(point1, 3.0, 4.0, 5.0);

        FigureUtil.draw(circle);
        FigureUtil.draw(rectangle, Color.GREY);
        FigureUtil.draw(square);
        FigureUtil.draw(triangle, Color.YELLOW);
    }
}
