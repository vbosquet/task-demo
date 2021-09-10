package org.altissia.vbosquet.taskdemo.job.book;

import org.altissia.vbosquet.taskdemo.model.Book;
import org.altissia.vbosquet.taskdemo.repository.BookRepository;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookWriter implements ItemWriter<Book>, StepExecutionListener {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public void write(List<? extends Book> books) throws Exception {
        books.forEach(newBook -> {
            if (!bookRepository.existsBooksByTitle(newBook.getTitle())) {
                bookRepository.save(newBook);
            }
        });
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
