package com.app.details.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.app.details.batch.StockDataSet;

@Repository
public class StockDetailsRepository {
	
		@Autowired
		JdbcTemplate jdbcTemplate;
		
		 public List<StockDataSet> getStockDataByStockName(String name){
				
		List<StockDataSet> results = jdbcTemplate.query("SELECT quarter, stock, date,  open,   high,  low,   close, volume, percentChangePrice,   percentChangeVolumeOverLastWk,   previousWeeksVolume, nextWeeksOpen,   nextWeeksClose,   percentChangeNextWeeksPrice,   daysToNextDividend, percentReturnNextDividend FROM stockDetails where stock="+"'"+ name+"'", new RowMapper<StockDataSet>() {
			@Override
			public StockDataSet mapRow(ResultSet rs, int row) throws SQLException {
				return new StockDataSet(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), 
						rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), 
						rs.getString(14), rs.getString(15), rs.getString(16));
			}
		});
		
		return results;
		 }
		 
		 public int addStockData(StockDataSet stock) {
			return jdbcTemplate.update("INSERT INTO stockDetails (quarter, stock, date,  open,   high,  low,   close, volume,   "
				 		+ "percentChangePrice,   percentChangeVolumeOverLastWk,   previousWeeksVolume," + 
				 		"        nextWeeksOpen,   nextWeeksClose,   percentChangeNextWeeksPrice,   daysToNextDividend," + 
				 		"        percentReturnNextDividend) VALUES ("+stock.getQuarter()+ ",'"+stock.getStock()+"','"+ stock.getDate()+ "','"+ stock.getOpen()+ "','"+ stock.getHigh()+"','"+stock.getLow()+"','"+ stock.getClose()+"',"+ stock.getVolume()+","+
		 				stock.getPercentChangePrice()+","+ stock.getPercentChangeVolumeOverLastWk()+","+ stock.getPreviousWeeksVolume()+",'"+
		 				stock.getNextWeeksOpen()+"','"+ stock.getNextWeeksClose()+"',"+ stock.getPercentChangeNextWeeksPrice()+","+stock.getDaysToNextDividend()+","+ stock.getPercentReturnNextDividend() +")");
				 		 
				
			 
			 
		 }

}
