package a.b.basewebappsb.service;

import a.b.basewebappsb.domain.Book;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ServiceBook {
    static Map<UUID,Book> mapIdBook =new HashMap<>();

    public ServiceBook() {}

    public void upsert(Book book) {
        if (book != null) {
            if (book.id == null) {
                book.id = UUID.randomUUID();
            }
            mapIdBook.put( book.id, book);
        }
    }

    public void delete(Book book) {
        if ( book != null && book.id != null ) {
            mapIdBook.remove(book.id);
        }
    }

    public Book get(UUID id) {
        book = mapIdBook.getOrDefault(id, null);
    }

    public List<Book> getAll() {
        List<Book> listBook = new ArrayList<>();

        mapIdBook.forEach((k,v) -> listBook.add(v));

        return listBook;
    }
}
