package org.altissia.vbosquet.taskdemo.service;

import org.altissia.vbosquet.taskdemo.model.Book;
import org.altissia.vbosquet.taskdemo.repository.BookRepository;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book save() {
        Book book = new Book();
        book.setTitle("Test");
        return bookRepository.save(book);
    }
}

