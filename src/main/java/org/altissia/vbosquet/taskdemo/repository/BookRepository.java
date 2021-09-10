package org.altissia.vbosquet.taskdemo.repository;

import org.altissia.vbosquet.taskdemo.model.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
