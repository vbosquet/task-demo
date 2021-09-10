package org.altissia.vbosquet.taskdemo.config;

import org.altissia.vbosquet.taskdemo.job.book.BookProcessor;
import org.altissia.vbosquet.taskdemo.job.book.BookWriter;
import org.altissia.vbosquet.taskdemo.model.Book;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.support.ListItemReader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

@Configuration
public class JobConfiguration {

    private final JobBuilderFactory jobBuilderFactory;

    private final StepBuilderFactory stepBuilderFactory;

    public JobConfiguration(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory) {
        this.jobBuilderFactory = jobBuilderFactory;
        this.stepBuilderFactory = stepBuilderFactory;
    }

    @Bean
    public Job bookJob(ItemProcessor<String, Book> itemProcessor, ItemWriter<Book> itemWriter) {
        Step step = stepBuilderFactory.get("BookProcessing")
                .<String, Book>chunk(1)
                .reader(new ListItemReader<>(Arrays.asList("7",
                        "2", "3", "10", "5", "6")))
                .processor(itemProcessor)
                .writer(itemWriter)
                .build();

        return jobBuilderFactory.get("BookJob")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean
    ItemProcessor<String, Book> itemProcessor() {
        return new BookProcessor();
    }

    @Bean
    ItemWriter<Book> itemWriter() {
        return new BookWriter();
    }
}
