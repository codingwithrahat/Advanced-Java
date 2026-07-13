public class Square implements Shape{

    double side;

    Square(double side){
        this.side = side;
    }

    @Override
    public void area() {
        IO.println("Square Area : " + (side * side));
    }
}
