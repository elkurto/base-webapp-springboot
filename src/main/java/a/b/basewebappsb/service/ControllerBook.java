package a.b.basewebappsb.service;

import a.b.basewebappsb.domain.Book;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController("/book")
public class ControllerBook {
    private final ServiceBook serviceBook;

    public ControllerBook(ServiceBook serviceBook) {
        this.serviceBook = serviceBook;
    }

    @GetMapping("/")
    public String index() {
        return "This is the /book controller";
    }

    @GetMapping("/one/:id")
    public Book getById(@PathVariable UUID id) {
        return this.serviceBook.get(id);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return this.serviceBook.getAll();
    }

    @PostMapping("/one")
    public Book upsert(Book book) {
        return this.serviceBook.upsert(book);
    }
}
