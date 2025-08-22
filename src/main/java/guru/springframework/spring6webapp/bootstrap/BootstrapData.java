package guru.springframework.spring6webapp.bootstrap;

import guru.springframework.spring6webapp.domain.Author;
import guru.springframework.spring6webapp.domain.Book;
import guru.springframework.spring6webapp.repositories.AuthorRepository;
import guru.springframework.spring6webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author author = new Author();
        author.setFirstName("James");
        author.setLastName("Clavell");

        Book book = new Book();
        book.setIsbn("123456789");
        book.setTitle("Noble House");

        Author authorSaved = authorRepository.save(author);
        Book bookSaved = bookRepository.save(book);

        Author author2 = new Author();
        author2.setFirstName("Robert");
        author2.setLastName("Ludlum");

        Book book2 = new Book();
        book2.setIsbn("987654321");
        book2.setTitle("Bourne Conspiracy");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        authorSaved.getBooks().add(bookSaved);
        author2Saved.getBooks().add(book2Saved);

        authorRepository.save(authorSaved);
        authorRepository.save(author2Saved);

        System.out.println("In Bootsrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());


    }
}
