public class VipDiscount implements Discount{
    @Override
    public double disCal(double amount) {
        return amount * 0.20; //20%
    }
}
