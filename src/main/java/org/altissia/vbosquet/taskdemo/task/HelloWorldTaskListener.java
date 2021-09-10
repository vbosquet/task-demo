package org.altissia.vbosquet.taskdemo.task;

import org.springframework.cloud.task.listener.TaskExecutionListener;
import org.springframework.cloud.task.repository.TaskExecution;

public class HelloWorldTaskListener implements TaskExecutionListener {

    @Override
    public void onTaskStartup(TaskExecution taskExecution) {
        System.out.println("Task Startup");
    }

    @Override
    public void onTaskEnd(TaskExecution taskExecution) {
        System.out.println("End of Task");
    }

    @Override
    public void onTaskFailed(TaskExecution taskExecution, Throwable throwable) {

    }
}
