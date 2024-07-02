package second;

public class Circle {
    private double radius;
    private String color;
    static double PI = 3.14159265358979323846;

    public Circle(double radius, String color) {
        this.radius = radius;
        this.color = color;
    }

    public double area() {
        return PI * radius * radius;
    }

    public double perimeter() {
        return 2 * PI * radius;
    }

    public String toString() {
        return (" " + radius + " " + color + " " + area() + " " + perimeter());
    }
}

