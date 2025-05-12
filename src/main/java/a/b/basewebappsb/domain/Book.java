package a.b.basewebappsb.domain;

import java.util.Objects;
import java.util.UUID;


public class Book {
    public UUID id;
    public String name;
    public String author;
    public long createdAt;

    public Book() {

    }

    public Book(UUID id, String name, String author, long createdAt) {
        this.id =id;
        this.name =name;
        this.author = author;
        this.createdAt = createdAt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return Objects.equals(this.id, book.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }
}
