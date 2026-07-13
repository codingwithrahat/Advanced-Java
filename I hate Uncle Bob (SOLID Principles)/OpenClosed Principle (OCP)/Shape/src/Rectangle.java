public class Rectangle implements Shape{

    double width, height;

    Rectangle(double width, double height){
        this.width = width;
        this.height = height;
    }


    @Override
    public void area() {
        IO.println("Rectangle Area: " + (width * height));
    }
}
