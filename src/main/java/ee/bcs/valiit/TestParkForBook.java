package ee.bcs.valiit;


import ee.bcs.valiit.tasks.Book;

public class TestParkForBook {

    public static void main(String[] args) {

        Book book = new Book();
        book.setTitle("Ameerika, Protsess, Loss");
        book.setAuthors("Franz Kafka");
        book.setNrOfPages(653);
        book.setYearOfRelease(1987);

    }
}

