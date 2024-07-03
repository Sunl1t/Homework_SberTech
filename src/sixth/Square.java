package sixth;

public class Square extends Rectangle {
    public Square(Point point, double side) {
        super(point, side, side);
    }

    @Override
    public String toString() {
        return "сторона:" + width + ", координаты:" + point;
    }

    @Override
    public void draw() {
        System.out.println("Квадрат нарисован по координатам " + point + " со стороной " + width + " черного цвета.");
    }

    @Override
    public void draw(Color color) {
        System.out.println("Квадрат нарисован по координатам " + point + " со стороной " + width + color + " цвета.");
    }
}
