package com.example.batch;

import org.springframework.batch.item.ItemWriter;

import javax.sql.DataSource;
import java.util.List;

public class ConsoleItemWriter implements ItemWriter<RecordPojo> {

    @Override
    public void write(List<? extends RecordPojo> items) throws Exception {
        for (RecordPojo item : items) {
            System.out.println("item.id: " + item.getId());
            System.out.println("item.name: " + item.getName());
            System.out.println("item.description: " + item.getDescription());
        }
    }
}
