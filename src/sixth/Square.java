package sixth;

public class Square extends Rectangle {
    public Square(Point point, double side) {
        super(point, side, side);
    }

    public String toString() {
        return "Square{" +
                "side=" + width +
                ", point=" + point +
                '}';
    }

    public void draw() {
        System.out.println("Квадрат нарисован по координатам " + point + " со стороной " + width + " черного цвета.");
    }

    public void draw(Color color) {
        System.out.println("Квадрат нарисован по координатам " + point + " со стороной " + width + color + " цвета.");
    }
}
