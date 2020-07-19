package com.app.details.batch;

import java.util.Date;

public class StockData {
	
	
    private int quarter;
    private String stock;
    private Date date;
    private String open;
    private String high;
    private String low;
    private String close;
    private Long volume;
    private double percentChangePrice;
    private double percentChangeVolumeOverLastWk;
    private Long previousWeeksVolume;
    private String nextWeeksOpen;
    private String nextWeeksClose;
    private double percentChangeNextWeeksPrice;
    private int daysToNextDividend;
    private double percentReturnNextDividend;
    
    public StockData() {
    }

    public StockData(int quarter, String stock, Date date,String open, String high,String low, String close,
      Long volume, double percentChangePrice, double percentChangeVolumeOverLastWk, Long previousWeeksVolume,
      String nextWeeksOpen, String nextWeeksClose, double percentChangeNextWeeksPrice, int daysToNextDividend,
      double percentReturnNextDividend) {
    
    		this.quarter = quarter;
    		this.stock = stock;
    		this.date = date;
    		this.open = open;
    		this.high = high;
    		this.low = low;
    		this.close= close;
    		this.nextWeeksOpen = nextWeeksOpen;
    		this.volume = volume;
    		this.percentChangePrice = percentChangePrice;
    		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
    		this.previousWeeksVolume = previousWeeksVolume;
    		this.nextWeeksClose = nextWeeksClose;
    		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
    		this.daysToNextDividend = daysToNextDividend;
    		this.percentReturnNextDividend = percentReturnNextDividend;
    
    }
    
	public int getQuarter() {
		return quarter;
	}

	public void setQuarter(int quarter) {
		this.quarter = quarter;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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

	public Long getVolume() {
		return volume;
	}

	public void setVolume(Long volume) {
		this.volume = volume;
	}

	public double getPercentChangePrice() {
		return percentChangePrice;
	}

	public void setPercentChangePrice(double percentChangePrice) {
		this.percentChangePrice = percentChangePrice;
	}

	public double getPercentChangeVolumeOverLastWk() {
		return percentChangeVolumeOverLastWk;
	}

	public void setPercentChangeVolumeOverLastWk(double percentChangeVolumeOverLastWk) {
		this.percentChangeVolumeOverLastWk = percentChangeVolumeOverLastWk;
	}

	public Long getPreviousWeeksVolume() {
		return previousWeeksVolume;
	}

	public void setPreviousWeeksVolume(Long previousWeeksVolume) {
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

	public double getPercentChangeNextWeeksPrice() {
		return percentChangeNextWeeksPrice;
	}

	public void setPercentChangeNextWeeksPrice(double percentChangeNextWeeksPrice) {
		this.percentChangeNextWeeksPrice = percentChangeNextWeeksPrice;
	}

	public int getDaysToNextDividend() {
		return daysToNextDividend;
	}

	public void setDaysToNextDividend(int daysToNextDividend) {
		this.daysToNextDividend = daysToNextDividend;
	}

	public double getPercentReturnNextDividend() {
		return percentReturnNextDividend;
	}

	public void setPercentReturnNextDividend(double percentReturnNextDividend) {
		this.percentReturnNextDividend = percentReturnNextDividend;
	}

	
	}
