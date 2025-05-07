package a.b.basewebappsb.domain;

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
}
