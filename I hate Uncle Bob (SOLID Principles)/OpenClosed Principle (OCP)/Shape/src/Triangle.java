public class Triangle implements Shape{
    double base, height;

    Triangle(double base, double height){
        this.base = base;
        this.height = height;
    }

    @Override
    public void area() {
        IO.println("Tringle Area: " + (0.50 * base * height));
    }
}
