public class StudentDiscount implements Discount{
    @Override
    public double disCal(double amount) {
        return amount * 0.15; //15%
    }
}
