package sixth;

public class Circle extends Figure implements Drawable
{
    private double radius;

    public Circle(Point point, double radius)
    {
        super(point);
        this.radius = radius;
    }

    public double area()
    {
        return Math.PI * radius * radius;
    }

    public double perimeter()
    {
        return 2 * Math.PI * radius;
    }

    public void draw()
    {
        System.out.println("Круг нарисован по координатам " + point + " радиуса " + radius + " чёрного цвета.");
    }

    public void draw(Color color) {
        System.out.println("Круг нарисован по координатам " + point + " радиуса " + radius +" "+ color + " цвета.");
    }
}
