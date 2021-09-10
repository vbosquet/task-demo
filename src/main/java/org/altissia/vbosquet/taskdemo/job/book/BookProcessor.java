package org.altissia.vbosquet.taskdemo.job.book;

import org.altissia.vbosquet.taskdemo.model.Book;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemProcessor;

public class BookProcessor implements ItemProcessor<String, Book>, StepExecutionListener {

    @Override
    public Book process(String s) throws Exception {
        Book book = new Book();
        book.setTitle(s);
        return book;
    }

    @Override
    public void beforeStep(StepExecution stepExecution) {

    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return ExitStatus.COMPLETED;
    }
}
