package app;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class BookApi {

    private List<Book> books;

    public BookApi() {
        Book book1 = new Book(1, "Spring w akcji", "Craig Walls", 620);
        Book book2 = new Book(2, "Thinking in Java", "Bruce Eckel", 1248);
        books = new ArrayList<>();
        books.add(book1);
        books.add(book2);
    }

    @PostMapping("/api/books")
    public void addBook(@RequestBody Book book) {
        books.add(book);
    }

    @GetMapping("/api/books")
    public List<Book> getBook() {
        return books;
    }

    @DeleteMapping("/api/books")
    public boolean removeBook(@RequestParam long id) {
        Optional<Book> first = books.stream().filter(x->x.getId() == id).findFirst();
        if(first.isPresent())
        {
            return books.remove(first.get());
        }
        return false;
    }
}
