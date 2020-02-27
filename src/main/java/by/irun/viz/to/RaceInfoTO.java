package by.irun.viz.to;
/**
 * Provides information about race for front-end representation
 * @author A.Dubovik
 */
public class RaceInfoTO implements InfoTO {

	private long raceId;
	private String raceName;
	/**
	 * @return the raceId
	 */
	public long getRaceId() {
		return raceId;
	}
	/**
	 * @param raceId the raceId to set
	 */
	public void setRaceId(long raceId) {
		this.raceId = raceId;
	}
	/**
	 * @return the raceName
	 */
	public String getRaceName() {
		return raceName;
	}
	/**
	 * @param raceName the raceName to set
	 */
	public void setRaceName(String raceName) {
		this.raceName = raceName;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (raceId ^ (raceId >>> 32));
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		RaceInfoTO other = (RaceInfoTO) obj;
		if (raceId != other.raceId)
			return false;
		return true;
	}

}
