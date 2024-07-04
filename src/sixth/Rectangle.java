package sixth;

public class Rectangle extends Figure implements Drawable {
    protected double width;
    protected double height;

    public Rectangle(Point point, double width, double height) {
        super(point);
        this.width = width;
        this.height = height;
    }

    @Override
    public double area() {
        return width * height;
    }

    @Override
    public double perimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("Прямоугольник нарисован по координатам " + point + " шириной " + width + " и длиной " + height + ", чёрного цвета.");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Прямоугольник нарисован по координатам " + point + " шириной " + width + " и длиной ," + height + " "+ color + " цвета.");
    }
}
