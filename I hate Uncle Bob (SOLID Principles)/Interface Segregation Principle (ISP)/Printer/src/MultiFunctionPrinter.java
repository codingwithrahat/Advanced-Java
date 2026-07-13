public class MultiFunctionPrinter implements Printable, Scannable, Faxable{
    @Override
    public void fax() {
        IO.println("Faxing");
    }

    @Override
    public void print() {
        IO.println("Printing");
    }

    @Override
    public void scan() {
        IO.println("Scanning");
    }
}
