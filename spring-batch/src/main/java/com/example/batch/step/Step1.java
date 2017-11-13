package com.example.batch.step;

import com.example.batch.ConsoleItemWriter;
import com.example.batch.RecordPojo;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.FieldSetMapper;
import org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper;
import org.springframework.batch.item.file.transform.FixedLengthTokenizer;
import org.springframework.batch.item.file.transform.LineTokenizer;
import org.springframework.batch.item.file.transform.Range;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class Step1 {

    @Bean
    public FlatFileItemReader<RecordPojo> fileReader(@Value("${input}") Resource in) throws Exception {
        FlatFileItemReader<RecordPojo> reader = new FlatFileItemReader<>();
        reader.setLinesToSkip(0);
        reader.setName("file-reader");
        reader.setResource(in);

        reader.setLineMapper(step1LineMapper());

        return reader;
    }

    private PatternMatchingCompositeLineMapper<RecordPojo> step1LineMapper() {
        PatternMatchingCompositeLineMapper<RecordPojo> mapper = new PatternMatchingCompositeLineMapper<>();

        Map<String, LineTokenizer> tokenizers = new HashMap<>();
        tokenizers.put("type1:*", type1Tokenizer());
        tokenizers.put("type2:*", type2Tokenizer());
        tokenizers.put("*", type1Tokenizer());   //default tokenizer, "*" matches everything
        mapper.setTokenizers(tokenizers);

        Map<String, FieldSetMapper<RecordPojo>> fieldSetMappers = new HashMap<>();
        BeanWrapperFieldSetMapper<RecordPojo> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(RecordPojo.class);
        fieldSetMappers.put("*", fieldSetMapper);
        mapper.setFieldSetMappers(fieldSetMappers);

        return mapper;
    }

    private LineTokenizer type1Tokenizer() {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setColumns(new Range[] { new Range(7, 14), new Range(15, 24), new Range(25, 50) });
        tokenizer.setNames(new String[] { "id", "name", "description" });
        return tokenizer;
    }

    private LineTokenizer type2Tokenizer() {
        FixedLengthTokenizer tokenizer = new FixedLengthTokenizer();
        tokenizer.setColumns(new Range[] { new Range(7, 18), new Range(19, 23), new Range(24, 50) });
        tokenizer.setNames(new String[] { "name", "id", "description" });
        return tokenizer;
    }

    @Bean
    public ItemWriter<RecordPojo> consoleWriter() {
        return new ConsoleItemWriter();
    }
}
