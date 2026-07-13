void main(){
    BasicPrinter b = new BasicPrinter();
    MultiFunctionPrinter m = new MultiFunctionPrinter();

    IO.println("Basic printer");
    b.print();

    IO.println("Multi function printer");
    m.print();
    m.scan();
    m.fax();
    
}