package a.b.basewebappsb.service;

import a.b.basewebappsb.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.temporal.ChronoUnit;
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

        Book book = serviceBook.get(id);
        if (book == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "404 - no book with id (="+ id +")");
        }
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

    @GetMapping("/all/flux")
    public Flux<Book> getAllFlux() {
        List<Book> listBook =this.serviceBook.getAll();
        Flux<Book> fluxBook = Flux.fromIterable(listBook);
        return fluxBook.delayElements( Duration.of(2, ChronoUnit.SECONDS));
    }

    @GetMapping("/all/mono")
    public Mono<List<Book>> getAllMono() {
        List<Book> listBook =this.serviceBook.getAll();
        Flux<Book> fluxBook = Flux.fromIterable(listBook).delayElements(Duration.of(2, ChronoUnit.SECONDS));

        return fluxBook.collectList();
    }
}
