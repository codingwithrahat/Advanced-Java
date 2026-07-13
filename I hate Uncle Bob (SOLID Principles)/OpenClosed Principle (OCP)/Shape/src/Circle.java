public class Circle implements Shape{
    double radius;

    Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public void area() {
        IO.println("Circle Area : " + (3.1416 * radius * radius));
    }
}
