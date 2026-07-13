public class PremiumDiscount implements Discount{
    @Override
    public double disCal(double amount) {
        return amount * 0.30; //30%
    }
}
