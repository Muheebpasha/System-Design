public class Main {
    public static void main(String[] args) {
        BookShelf shelf = new BookShelf();
        shelf.addBook("Book A");
        shelf.addBook("Book B");
        shelf.addBook("Book C");

        Iterator iterator = shelf.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}