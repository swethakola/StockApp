package com.app.details.batch;

 
public class StockDataSet {
	
	
    private String quarter;
    private String stock;
    private String date;
    private String open;
    private String high;
    private String low;
    private String close;
    private String volume;
    private String percentChangePrice;
    private String percentChangeVolumeOverLastWk;
    private String previousWeeksVolume;
    private String nextWeeksOpen;
    private String nextWeeksClose;
    private String percentChangeNextWeeksPrice;
    private String daysToNextDividend;
    private String percentReturnNextDividend;
    
    public StockDataSet() {
    	
    }
    public StockDataSet(String quarter,String stock, String date,String open,String high,String low,String close,String volume,
    		String percentChangePrice,String percentChangeVolumeOverLastWk,String previousWeeksVolume, String nextWeeksOpen,
    		String nextWeeksClose, String percentChangeNextWeeksPrice, String daysToNextDividend, String percentReturnNextDividend) {
    	this.quarter = quarter;
    	this.stock = stock;
    	this.date = date;
    	this.open = open;
    	this.high = high;
    	this.low = low;
    	this.close = close;
    	this.volume = volume;
    	this.percentChangePrice = percentChangePrice;
    	this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
    	this.previousWeeksVolume = previousWeeksVolume;
    	this.nextWeeksOpen = nextWeeksOpen;
    	this.nextWeeksClose = nextWeeksClose;
    	this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;		
    	this.daysToNextDividend = daysToNextDividend;
    	this.percentReturnNextDividend = percentReturnNextDividend;
    }

	public String getStock() {
		return stock;
	}
	
	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getQuarter() {
		return quarter;
	}

	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getOpen() {
		return open;
	}

	public void setOpen(String open) {
		this.open = open;
	}

	public String getHigh() {
		return high;
	}

	public void setHigh(String high) {
		this.high = high;
	}

	public String getLow() {
		return low;
	}

	public void setLow(String low) {
		this.low = low;
	}

	public String getClose() {
		return close;
	}

	public void setClose(String close) {
		this.close = close;
	}

	public String getVolume() {
		return volume;
	}

	public void setVolume(String volume) {
		this.volume = volume;
	}

	public String getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(String percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public String getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(String percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public String getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(String previousWeeksVolume) {
		this.previousWeeksVolume = previousWeeksVolume;
	}

	public String getNextWeeksOpen() {
		return nextWeeksOpen;
	}

	public void setNextWeeksOpen(String nextWeeksOpen) {
		this.nextWeeksOpen = nextWeeksOpen;
	}

	public String getNextWeeksClose() {
		return nextWeeksClose;
	}

	public void setNextWeeksClose(String nextWeeksClose) {
		this.nextWeeksClose = nextWeeksClose;
	}

	public String getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(String percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public String getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(String daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public String getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(String percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}
	
	}
