void main(){
    BirdFly s = new Sparrow();
    BirdSwim p = new Penguin();

    IO.println("Sparrow");
    s.eat();
    s.fly();

    IO.println("Penguin");
    p.eat();
    p.swim();

}