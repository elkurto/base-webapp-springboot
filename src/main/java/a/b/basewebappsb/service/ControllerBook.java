package a.b.basewebappsb.service;

import a.b.basewebappsb.domain.Book;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;

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

    @GetMapping("/one/{id}")
    public Book getById(@PathVariable UUID id) {
        return this.serviceBook.get(id);
    }

    @GetMapping("/all")
    public List<Book> getAll() {
        return this.serviceBook.getAll();
    }

    @PostMapping("/one")
    public ResponseEntity<Book> upsert(@RequestBody Book book, UriComponentsBuilder uriBuilder) {
        Book bookUpdated =this.serviceBook.upsert(book);
        var newBookUri = uriBuilder.path("/books/{isbn}").build(bookUpdated.id);

        return ResponseEntity.created(newBookUri).body(bookUpdated);
    }

    @DeleteMapping("/one/{id}")
    public ResponseEntity<String> remove(@PathVariable UUID id) {
        this.serviceBook.removeById(id);

        return ResponseEntity.noContent().build();
    }
}
