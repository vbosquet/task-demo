package org.altissia.vbosquet.taskdemo.repository;

import org.altissia.vbosquet.taskdemo.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
