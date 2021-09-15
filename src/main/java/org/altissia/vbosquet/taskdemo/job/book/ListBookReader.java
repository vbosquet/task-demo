package org.altissia.vbosquet.taskdemo.job.book;

import com.thedeanda.lorem.Lorem;
import com.thedeanda.lorem.LoremIpsum;
import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.NonTransientResourceException;
import org.springframework.batch.item.ParseException;
import org.springframework.batch.item.UnexpectedInputException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class ListBookReader implements ItemReader<List<String>>, StepExecutionListener {

    private List data;

    @Override
    public void beforeStep(StepExecution stepExecution) {
    }

    @Override
    public ExitStatus afterStep(StepExecution stepExecution) {
        return null;
    }

    @Override
    public List<String> read() throws Exception, UnexpectedInputException, ParseException, NonTransientResourceException {
        data = new ArrayList();
        IntStream.range(0, 5).forEach(i -> {
            Lorem lorem = LoremIpsum.getInstance();
            data.add(lorem.getTitle(2, 4));
        });
        return data;
    }
}
