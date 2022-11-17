package Tema1;

public abstract class IdNameBooks extends NameAndId{
    private Book[] books;

    public IdNameBooks(int ID, String name, Book[] books) {
        super(ID, name);
        this.books = books;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }
}
