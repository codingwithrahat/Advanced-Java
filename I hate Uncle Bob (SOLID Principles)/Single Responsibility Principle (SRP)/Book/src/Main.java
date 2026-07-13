void main(){
    Book b = new Book("ICT", "Rahat");
    PrintBook p = new PrintBook();

    p.bookInfo(b);

    Database d = new Database();

    d.connect(b);
}