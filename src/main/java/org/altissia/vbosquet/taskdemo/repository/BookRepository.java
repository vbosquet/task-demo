package org.altissia.vbosquet.taskdemo.repository;

import org.altissia.vbosquet.taskdemo.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
    boolean existsBooksByTitle(String string);
}
