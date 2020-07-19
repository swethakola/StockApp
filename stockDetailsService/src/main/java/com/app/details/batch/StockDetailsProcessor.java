package com.app.details.batch;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class StockDetailsProcessor implements ItemProcessor<StockDataSet, StockData> {
	
    private static final Logger log = LoggerFactory.getLogger(StockDetailsProcessor.class);
    
    @Override
    public StockData process(final StockDataSet stockDataSet) throws Exception {
    	
    	final int quarter = Integer.valueOf(stockDataSet.getQuarter());
        final String stockname = stockDataSet.getStock();
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        Date date = formatter.parse(stockDataSet.getDate());
        final String open = stockDataSet.getOpen();
        final String close = stockDataSet.getClose();
        final String high = stockDataSet.getHigh();
        final String low = stockDataSet.getLow();
        final double percentChangePrice = Double.valueOf(stockDataSet.getPercentChangePrice().isEmpty() ? "0":  stockDataSet.getPercentChangePrice());
        final double percentChangeVolumeOverLastWk = Double.valueOf(stockDataSet.getPercentChangeVolumeOverLastWk().isEmpty() ? "0": stockDataSet.getPercentChangeVolumeOverLastWk());
        final String nextWeeksOpen = stockDataSet.getNextWeeksOpen();
        final String nextWeeksClose = stockDataSet.getNextWeeksClose();
        final double percentChangeNextWeeksPrice = Double.valueOf(stockDataSet.getPercentChangeNextWeeksPrice().isEmpty() ? "0": stockDataSet.getPercentChangeNextWeeksPrice() );
        final double percentReturnNextDividend = Double.valueOf(stockDataSet.getPercentReturnNextDividend().isEmpty() ? "0":  stockDataSet.getPercentReturnNextDividend());
        final Long previousWeeksVolume = Long.valueOf(stockDataSet.getPreviousWeeksVolume().isEmpty() ? "0": stockDataSet.getPreviousWeeksVolume());
        final Long volume = Long.valueOf(stockDataSet.getVolume());
        final int daysToNextDividend = Integer.valueOf(stockDataSet.getDaysToNextDividend());
        
        final StockData transformedStock = new StockData(quarter, stockname, date,open,  high,low, close,
        	      volume,  percentChangePrice, percentChangeVolumeOverLastWk,  previousWeeksVolume,
        	       nextWeeksOpen,  nextWeeksClose,  percentChangeNextWeeksPrice,  daysToNextDividend,
        	       percentReturnNextDividend);


        return transformedStock;
    }

}
