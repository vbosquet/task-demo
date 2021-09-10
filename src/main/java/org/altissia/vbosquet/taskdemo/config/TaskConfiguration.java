package org.altissia.vbosquet.taskdemo.config;

import org.altissia.vbosquet.taskdemo.task.HelloWorldTask;
import org.altissia.vbosquet.taskdemo.task.HelloWorldTaskListener;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@EnableTask
@EnableBatchProcessing
public class TaskConfiguration {

    private final DataSource dataSource;

    public TaskConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public HelloWorldTask getTaskConfigurer() {
        return new HelloWorldTask(dataSource);
    }

    @Bean
    public HelloWorldTaskListener taskListener() {
        return new HelloWorldTaskListener();
    }
}
