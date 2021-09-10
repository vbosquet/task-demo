package org.altissia.vbosquet.taskdemo.task;

import org.springframework.cloud.task.configuration.DefaultTaskConfigurer;

import javax.sql.DataSource;

public class HelloWorldTask extends DefaultTaskConfigurer {
    public HelloWorldTask(DataSource dataSource) {
        super(dataSource);
    }
}
