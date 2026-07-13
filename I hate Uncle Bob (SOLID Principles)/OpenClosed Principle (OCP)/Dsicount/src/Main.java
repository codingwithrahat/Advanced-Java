void main(){

    double amount = 4000;

    Discount v = new VipDiscount();
    Discount r = new RegularDiscount();
    Discount p = new PremiumDiscount();

    DiscountCalculator dc = new DiscountCalculator();

    IO.println("Vip Discount : " + v.disCal(amount));
    IO.println("Regular Discount : " + r.disCal(amount));
    IO.println("Premium Discount : " + p.disCal(amount));

    Discount s = new StudentDiscount();

    IO.println("Student Discount : " + s.disCal(amount));
}