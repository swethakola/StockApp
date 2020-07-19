package com.app.details.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;

@EnableBatchProcessing
@Configuration
public class CsvFileToDatabaseConfig {
	
	private static final String WILL_BE_INJECTED = null;
	
    @Autowired
    public JobBuilderFactory jobBuilderFactory;

    @Autowired
    public StepBuilderFactory stepBuilderFactory;

    @Autowired
    public DataSource dataSource;

    
    @Bean
    @StepScope
    public FlatFileItemReader<StockDataSet> csvStockReader(@Value("#{jobParameters['fileName']}") String fileName){
        FlatFileItemReader<StockDataSet> reader = new FlatFileItemReader<StockDataSet>();
        System.out.println("fileName"+fileName);
        reader.setResource(new FileSystemResource(fileName));
        reader.setLinesToSkip(1);
        reader.setLineMapper(new DefaultLineMapper<StockDataSet>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames(new String[] {  "quarter","stock","date","open","high","low","close","volume","percentChangePrice",
						"percentChangeVolumeOverLastWk","previousWeeksVolume","nextWeeksOpen","nextWeeksClose",
						"percentChangeNextWeeksPrice","daysToNextDividend","percentReturnNextDividend"  });
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper<StockDataSet>() {{
                setTargetType(StockDataSet.class);
            }});
        }});
        return reader;
    }


	@Bean
	ItemProcessor<StockDataSet, StockData> csvStockProcessor() {
		return new StockDetailsProcessor();
	}

	@Bean
	 @StepScope
	public JdbcBatchItemWriter<StockData> csvStockWriter() {
		 JdbcBatchItemWriter<StockData> csvStockWriter = new JdbcBatchItemWriter<StockData>();
		 csvStockWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<StockData>());
		 csvStockWriter.setSql("INSERT INTO stockDetails (quarter, stock, date,  open,   high,  low,   close,volume,   "
		 		+ "percentChangePrice,   percentChangeVolumeOverLastWk,   previousWeeksVolume," + 
		 		"        nextWeeksOpen,   nextWeeksClose,   percentChangeNextWeeksPrice,   daysToNextDividend," + 
		 		"        percentReturnNextDividend) VALUES (:quarter, :stock, :date,  :open,   :high,  :low,   :close, :volume, :percentChangePrice,   :percentChangeVolumeOverLastWk,   :previousWeeksVolume, :nextWeeksOpen,   :nextWeeksClose,   :percentChangeNextWeeksPrice,   :daysToNextDividend,  :percentReturnNextDividend)");
		 csvStockWriter.setDataSource(dataSource);
	        return csvStockWriter;
	}

	 
	@Bean
	public Step csvFileToDatabaseStep() {
		return stepBuilderFactory.get("csvFileToDatabaseStep")
				.<StockDataSet, StockData>chunk(1)
				.reader(csvStockReader(WILL_BE_INJECTED))
				.processor(csvStockProcessor())
				.writer(csvStockWriter())
				.taskExecutor(taskExecutor())
				.build();
	}

	@Bean
	Job csvFileToDatabaseJob(JobCompletionNotificationListener listener) {
		return jobBuilderFactory.get("csvFileToDatabaseJob")
				.incrementer(new RunIdIncrementer())
				.listener(listener)
				.flow(csvFileToDatabaseStep())
				.end()
				.build();
	}
	
	 
	
	@Bean
	public TaskExecutor taskExecutor(){
	    SimpleAsyncTaskExecutor asyncTaskExecutor=new SimpleAsyncTaskExecutor("spring_batch");
	    asyncTaskExecutor.setConcurrencyLimit(5);
	    return asyncTaskExecutor;
	}
    
	 
}
