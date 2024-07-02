package sixth;

public class Rectangle extends Figure implements Drawable {
    protected double width;
    protected double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    public double area() {
        return width * height;
    }

    public double perimeter() {
        return 2 * (width + height);
    }

    public void draw() {
        System.out.println("Прямоугольник нарисован по координатам " + point + " шириной " + width + " и длиной " + height + ", чёрного цвета.");
    }

    public void draw(Color color) {
        System.out.println("Прямоугольник нарисован по координатам " + point + " шириной " + width + " и длиной ," + height + " "+ color + " цвета.");
    }
}
