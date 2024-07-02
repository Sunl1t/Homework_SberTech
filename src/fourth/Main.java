package fourth;

public class Main {
    public static void main(String[] args) {
        Author author = new Author("J.K. Rowling", "Female", "jk.rowling@gmail.com");
        Book book = new Book("Harry Potter", author, 1997);

        System.out.println(author);
        System.out.println(book);
    }
}
