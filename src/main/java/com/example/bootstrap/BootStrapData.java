package com.example.bootstrap;

import com.example.entity.Author;
import com.example.entity.Book;
import com.example.entity.Publisher;
import com.example.repository.AuthorRepository;
import com.example.repository.BookRepository;
import com.example.repository.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("In Bootstrap class");
        Publisher publisher=new Publisher();
        publisher.setAddressLine("Chandrakantham");
        publisher.setCity("Kannur");
        publisher.setState("Kerala");
        publisher.setZip("670301");
        publisher.setName("Mathribhumi");
        publisherRepository.save(publisher);
        System.out.println("No of publisher" +publisherRepository.count());

        Author jishnu=new Author("Jishnu" ,"Janardhanan");
        Book xyz=new Book("Shantharam","1234");
        jishnu.getBooks().add(xyz);
        xyz.getAuthor().add(jishnu);
        xyz.setPublisher(publisher);

        bookRepository.save(xyz);
        authorRepository.save(jishnu);
    }
}
