package by.irun.viz.to;

import java.util.List;

/**
 * Provides TO for list of best results in park
 * @author Home
 *
 */
public class ParkBestResultInfoTO {
	
	private String parkName;
	private List<String>bestResults;
	/**
	 * @return the parkName
	 */
	public String getParkName() {
		return parkName;
	}
	/**
	 * @param parkName the parkName to set
	 */
	public void setParkName(String parkName) {
		this.parkName = parkName;
	}
	/**
	 * @return the bestResults
	 */
	public List<String> getBestResults() {
		return bestResults;
	}
	/**
	 * @param bestResults the bestResults to set
	 */
	public void setBestResults(List<String> bestResults) {
		this.bestResults = bestResults;
	}
	
	

}
