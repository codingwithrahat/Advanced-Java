public class RegularDiscount implements Discount{
    @Override
    public double disCal(double amount) {
        return amount * 0.10; //10%
    }
}
