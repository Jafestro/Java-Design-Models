package Prototype.Bookstore;

import java.util.ArrayList;
import java.util.List;

public class Recommendation implements Cloneable {
    private String targetAudience;
    private List<Book> books;

    public Recommendation(String targetAudience) {
        this.targetAudience = targetAudience;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void removeBook(int index) {
        if (index >= 0 && index < books.size()) {
            books.remove(index);
        }
    }

    public void updateAudience(String newAudience) {
        this.targetAudience = newAudience;
    }

    @Override
    protected Recommendation clone() {
        try {
            Recommendation cloned = (Recommendation) super.clone();
            cloned.books = new ArrayList<>();
            for (Book book : this.books) {
                cloned.books.add(book.clone());
            }
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Cloning not supported for Recommendation");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Target Audience: " + targetAudience + "\nBooks:\n");
        if (books.isEmpty()) {
            sb.append("No books available\n");
        } else {
            for (int i = 0; i < books.size(); i++) {
                sb.append((i + 1) + ". " + books.get(i) + "\n");
            }
        }
        return sb.toString();
    }
}

