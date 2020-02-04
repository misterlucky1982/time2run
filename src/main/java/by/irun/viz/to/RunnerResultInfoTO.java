package by.irun.viz.to;

/**
 * This class provides information of the runner`s result in particular race
 * @author A.Dubovik
 */
public class RunnerResultInfoTO {
	
	private String raceInfo;
	private String absPositionInfo;
	private String posInOwnGenderInfo;
	private String time;
	private String linkToRace;
	/**
	 * @return the raceInfo
	 */
	public String getRaceInfo() {
		return raceInfo;
	}
	/**
	 * @param raceInfo the raceInfo to set
	 */
	public void setRaceInfo(String raceInfo) {
		this.raceInfo = raceInfo;
	}
	/**
	 * @return the absPositionInfo
	 */
	public String getAbsPositionInfo() {
		return absPositionInfo;
	}
	/**
	 * @param absPositionInfo the absPositionInfo to set
	 */
	public void setAbsPositionInfo(String absPositionInfo) {
		this.absPositionInfo = absPositionInfo;
	}
	/**
	 * @return the posInOwnGenderInfo
	 */
	public String getPosInOwnGenderInfo() {
		return posInOwnGenderInfo;
	}
	/**
	 * @param posInOwnGenderInfo the posInOwnGenderInfo to set
	 */
	public void setPosInOwnGenderInfo(String posInOwnGenderInfo) {
		this.posInOwnGenderInfo = posInOwnGenderInfo;
	}
	/**
	 * @return the time
	 */
	public String getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(String time) {
		this.time = time;
	}
	/**
	 * @return the linkToRace
	 */
	public String getLinkToRace() {
		return linkToRace;
	}
	/**
	 * @param linkToRace the linkToRace to set
	 */
	public void setLinkToRace(String linkToRace) {
		this.linkToRace = linkToRace;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((absPositionInfo == null) ? 0 : absPositionInfo.hashCode());
		result = prime * result + ((linkToRace == null) ? 0 : linkToRace.hashCode());
		result = prime * result + ((posInOwnGenderInfo == null) ? 0 : posInOwnGenderInfo.hashCode());
		result = prime * result + ((raceInfo == null) ? 0 : raceInfo.hashCode());
		result = prime * result + ((time == null) ? 0 : time.hashCode());
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
		RunnerResultInfoTO other = (RunnerResultInfoTO) obj;
		if (absPositionInfo == null) {
			if (other.absPositionInfo != null)
				return false;
		} else if (!absPositionInfo.equals(other.absPositionInfo))
			return false;
		if (linkToRace == null) {
			if (other.linkToRace != null)
				return false;
		} else if (!linkToRace.equals(other.linkToRace))
			return false;
		if (posInOwnGenderInfo == null) {
			if (other.posInOwnGenderInfo != null)
				return false;
		} else if (!posInOwnGenderInfo.equals(other.posInOwnGenderInfo))
			return false;
		if (raceInfo == null) {
			if (other.raceInfo != null)
				return false;
		} else if (!raceInfo.equals(other.raceInfo))
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}
	
}
