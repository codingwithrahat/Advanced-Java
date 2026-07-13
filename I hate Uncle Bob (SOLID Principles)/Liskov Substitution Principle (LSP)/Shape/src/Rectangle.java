public class Rectangle implements Shape{
    double width, height;

    Rectangle(double width, double height){
        this.height = height;
        this.width = width;
    }

    @Override
    public void area(){
        IO.println("Rectangle Area : " + (width * height));
    }

}
