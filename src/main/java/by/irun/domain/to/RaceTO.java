package by.irun.domain.to;

import java.sql.Date;

/**
 * Provides information about race for transfer data from entity-layer to viz-layer
 * @author A.Dubovik
 *
 */
public class RaceTO {

	private String parkName;
	
	private Date date;

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
	 * @return the date
	 */
	public Date getDate() {
		return date;
	}

	/**
	 * @param date the date to set
	 */
	public void setDate(Date date) {
		this.date = date;
	}
	
	
}
