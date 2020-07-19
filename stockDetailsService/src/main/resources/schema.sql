DROP TABLE stockDetails IF EXISTS;
CREATE TABLE stockDetails  (
	
    quarter int,
    stock VARCHAR(20),
    date DATE,
    open VARCHAR(10),
    high VARCHAR(10),
    low VARCHAR(10),
    close VARCHAR(10),
    volume BIGINT,
    percentChangePrice decimal(10,7),
    percentChangeVolumeOverLastWk decimal(12,9),
    previousWeeksVolume BIGINT,
    nextWeeksOpen VARCHAR(10),
    nextWeeksClose VARCHAR(10),
    percentChangeNextWeeksPrice decimal(9,7),
    daysToNextDividend int,
    percentReturnNextDividend decimal(9,7)
    );
    

