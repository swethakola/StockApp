package com.app.details.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.details.batch.StockDataSet;
import com.app.details.service.StockDetailsService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")

public class StockDetailsController {

	 @Autowired
	    public StockDetailsService service;
	
	 
	 @RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE, produces=MediaType.TEXT_PLAIN_VALUE )
	  public String uploadFile(@RequestPart("file") MultipartFile file) {
	    String message = "";
	    try {
	    	System.out.println("-===="+file.getOriginalFilename());
	    	service.processAndSave(file);

	      message = "Uploaded the file successfully: " + file.getOriginalFilename();
	      return message;
	    } catch (Exception e) {
	      message = "Could not upload the file: " + file.getOriginalFilename() + "!";
	      return message;
	    }
	  }
	 
	@GetMapping("/getStock")
	public List<StockDataSet> getStockDataByStockName(@RequestParam String name){
		System.out.println("name"+name);
		List<StockDataSet> stockData =  service.getStockDataByStockName(name);
		return stockData;
	}
	
	@PostMapping("/addStock")
	public int addStockData( @RequestBody StockDataSet stock){
		
		System.out.println("stockname"+stock.getStock());
		  return  service.addStockData(stock);
	}
}
