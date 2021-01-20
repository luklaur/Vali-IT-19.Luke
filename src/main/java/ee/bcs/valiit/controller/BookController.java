package ee.bcs.valiit.controller;

import ee.bcs.valiit.TestParkForBook;
import ee.bcs.valiit.tasks.Book;
import ee.bcs.valiit.tasks.Lesson2;
import org.springframework.web.bind.annotation.*;

@RequestMapping("tasks")
@RestController
public class BookController {
    // http://localhost:8080/tasks

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
