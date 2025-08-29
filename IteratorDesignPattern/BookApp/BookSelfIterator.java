public class BookSelfIterator implements Iterator {
    private BookShelf bookShelf;
    private int index;

    public BookSelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        return index < bookShelf.getBooks().size();
    }

    @Override
    public String next() {
        if (hasNext()) {
            return bookShelf.getBooks().get(index++);
        }
        return null;
    }
}