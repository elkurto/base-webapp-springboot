package a.b.basewebappsb.service;

import a.b.basewebappsb.domain.Book;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.*;

@Component
public class ServiceBook {
    private static final Map<UUID,Book> mapIdBook =new HashMap<>();
    static {
        final long now_epoch_seconds =System.currentTimeMillis() / 1000;
        final List<Book> listBook = new ArrayList<>();
        listBook.add( new Book(UUID.randomUUID(), "Docker Deep Dive", "Poulton", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "Art Of War", "Tsu", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "The Nail", "Davis,Farmer", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "Art Of Webassembly", "Battagline", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "1984", "Orwell", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "Python 3", "Ernesti,Kaiser", now_epoch_seconds));
        listBook.add( new Book(UUID.randomUUID(), "ALG & DS in Python", "Canning,Broder,Lafore", now_epoch_seconds));

        for (Book book : listBook) {
            mapIdBook.put(book.id, book);
        }
    }

    public ServiceBook() {}

    public Book upsert(Book book) {
        if (book != null) {
            if (book.id == null) {
                book.id = UUID.randomUUID();
            }
            mapIdBook.put( book.id, book);
        }
        return book;
    }

    public void removeById(UUID id) {
        if ( id != null ) {
            mapIdBook.remove(id);
        }
    }
    public void remove(Book book) {
        if ( book != null ) {
            this.removeById(book.id);
        }
    }

    public Book get(UUID id) {
        return mapIdBook.getOrDefault(id, null);
    }

    public List<Book> getAll() {
        List<Book> listBook = new ArrayList<>();

        mapIdBook.forEach((k,v) -> listBook.add(v));

        return listBook;
    }
}
