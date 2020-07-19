package com.app.details.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.JobParametersInvalidException;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.app.details.batch.StockDataSet;
import com.app.details.property.FileStorageProperties;
import com.app.details.repository.StockDetailsRepository;

@Service
public class StockDetailsService {
	 
	 @Autowired
	 public  StockDetailsRepository repository;
	 
	 @Autowired
	    JobLauncher jobLauncher;

	    @Autowired
	    Job job;

	    private final Path fileStorageLocation;

	    @Autowired
	    public StockDetailsService(FileStorageProperties fileStorageProperties) {
	        this.fileStorageLocation = Paths.get(fileStorageProperties.getUploadDir())
	                .toAbsolutePath().normalize();

	        try {
	            Files.createDirectories(this.fileStorageLocation);
	        } catch (Exception ex) {
	            throw new RuntimeException("Could not create the directory where the uploaded files will be stored.", ex);
	        }
	    }

	    public String processAndSave(MultipartFile file) throws JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException, JobParametersInvalidException {
	        String fileName = StringUtils.cleanPath(file.getOriginalFilename());

	        try {
	            // Check if the file's name contains invalid characters
	            if(fileName.contains("..")) {
	                throw new RuntimeException("Sorry! Filename contains invalid path sequence " + fileName);
	            }

	            Path targetLocation = this.fileStorageLocation.resolve(fileName);
	            Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
	            final JobParametersBuilder jobParametersBuilder = new JobParametersBuilder();
	            String filepath =fileStorageLocation+"\\"+fileName;
	            System.out.println(filepath);
	            jobParametersBuilder.addString("fileName", filepath);

	            final JobParameters jobParameters = jobParametersBuilder.toJobParameters();

	            jobLauncher.run(job, jobParameters);
	            return fileName;
	        } catch (IOException ex) {
	            throw new RuntimeException("Could not store file " + fileName + ". Please try again!", ex);
	        }
	    }

	   
	 
	 
	 public List<StockDataSet> getStockDataByStockName(String name){
		 System.out.println("name:"+name);
		 List<StockDataSet> results = repository.getStockDataByStockName(name);
		 System.out.println(results.size());
		 return results;
	 }
	 
	 
	 public int addStockData(StockDataSet stock) {
		 return repository.addStockData(stock);
	 }
}
