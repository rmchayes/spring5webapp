package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;


    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author robert = new Author("robert", "hayes");
        Book book1 = new Book("booky", "12345");
        robert.getBooks().add(book1);
        book1.getAuthors().add(robert);

        authorRepository.save(robert);
        bookRepository.save(book1);

        Author tika = new Author("tika", "hayes");
        Book book2 = new Book("booku", "12345");
        tika.getBooks().add(book2);
        book2.getAuthors().add(tika);

        authorRepository.save(tika);
        bookRepository.save(book2);

        System.out.println("Starting bootstrap");
        System.out.println("Number of books is " + bookRepository.count());

    }
}
