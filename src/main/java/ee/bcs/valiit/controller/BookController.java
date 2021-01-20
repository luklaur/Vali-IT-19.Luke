package ee.bcs.valiit.controller;

import ee.bcs.valiit.TestParkForBook;
import ee.bcs.valiit.tasks.Book;
import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RequestMapping("tasks")
@RestController
public class BookController {

//    HashMap<String, String> raamatud = new HashMap<>();

    private List<Book> raamatud = new ArrayList<>();

    // RequestBody????
    // http://localhost:8080/tasks/addBook
    @PostMapping("addBook")
    public void addBook(@RequestBody Book book) {
        raamatud.add(book);
    }

    // http://localhost:8080/tasks/viewBook?all
    @GetMapping("viewBook")
    public List<Book> viewBook(@RequestParam("all") String all) {
        return raamatud;
    }

    // http://localhost:8080/tasks/viewBook/3
    @GetMapping("viewBook/{ID}")
    public Book viewBook(@PathVariable("ID") int ID) {
        return raamatud.get(ID);
    }

    // http://localhost:8080/tasks/replaceBook/2
    @PutMapping("replaceBook/{ID}")
    public void replaceBook(@RequestBody Book book, @PathVariable("ID") int ID) {
        raamatud.set(ID, book);
    }

    // http://localhost:8080/tasks/deleteBook/2
    @DeleteMapping("deleteBook/{ID}")
    public void deleteBook(@PathVariable("ID") int ID) {
        raamatud.remove(ID);
    }


    // http://localhost:8080/tasks/Book?title=Ulmeraamat&authors=Priit&yearOfRelease=2020&nrOfPages=666
    @GetMapping("Book")
    public Book book(@RequestParam("title") String title,
                     @RequestParam("authors") String authors,
                     @RequestParam("yearOfRelease") int yearOfRelease,
                     @RequestParam("nrOfPages") int nrOfPages) {
        Book book = new Book();
        book.setTitle(title);
        book.setAuthors(authors);
        book.setYearOfRelease(yearOfRelease);
        book.setNrOfPages(nrOfPages);

        return book;
    }
}
