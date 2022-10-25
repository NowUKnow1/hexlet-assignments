package exercise;

// BEGIN
public class Circle {
    Point point;
    Integer radius;

    public Circle(Point point, Integer radius) {
        this.point = point;
        this.radius = radius;
    }

    public Circle() {
    }

    public Integer getRadius() {
        return radius;
    }

    public double getSquare() throws NegativeRadiusException {
        if (radius < 0) {
            throw new NegativeRadiusException("Radius is negative");
        } else {
            final double PI = 3.14159;
            return radius * radius * PI;
        }
    }
}
// END
