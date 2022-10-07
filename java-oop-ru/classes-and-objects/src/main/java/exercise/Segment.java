package exercise;

// BEGIN
public class Segment {
    Point firstPoint;
    Point secondPoint;
    public Segment(Point firstPoint, Point secondPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
    }
    public Segment(){
    }
    public Point getBeginPoint() {
        return firstPoint;
    }
    public Point getEndPoint() {
        return secondPoint;
    }
    public Point getMidPoint() {
        int firstPointX = firstPoint.getX();
        int secondPointX = secondPoint.getX();
        int firstPointY = firstPoint.getY();
        int secondPointY = secondPoint.getY();
        Point midPoint = new Point();
        int midPointX = (firstPointX + secondPointX) / 2;
        int midPointY = (firstPointY + secondPointY) / 2;
        midPoint.setX(midPointX);
        midPoint.setY(midPointY);
        return midPoint;
    }
}
// END
