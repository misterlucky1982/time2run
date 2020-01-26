package by.irun.inf.ob;

/**
 * Provides information about result for front-end representation
 * @author A.Dubovik
 */
public class RaceResultTO {
	
	private int absPosition;
	private int positionInGroup;
	private String name;
	private String gender;
	private String club;
	private String time;
	
	/**
	 * @return the absPosition
	 */
	public int getAbsPosition() {
		return absPosition;
	}
	/**
	 * @param absPosition the absPosition to set
	 */
	public void setAbsPosition(int absPosition) {
		this.absPosition = absPosition;
	}
	/**
	 * @return the positionInGroup
	 */
	public int getPositionInGroup() {
		return positionInGroup;
	}
	/**
	 * @param positionInGroup the positionInGroup to set
	 */
	public void setPositionInGroup(int positionInGroup) {
		this.positionInGroup = positionInGroup;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}
	/**
	 * @return the club
	 */
	public String getClub() {
		return club;
	}
	/**
	 * @param club the club to set
	 */
	public void setClub(String club) {
		this.club = club;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + absPosition;
		result = prime * result + ((club == null) ? 0 : club.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + positionInGroup;
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
		RaceResultTO other = (RaceResultTO) obj;
		if (absPosition != other.absPosition)
			return false;
		if (club == null) {
			if (other.club != null)
				return false;
		} else if (!club.equals(other.club))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (positionInGroup != other.positionInGroup)
			return false;
		if (time == null) {
			if (other.time != null)
				return false;
		} else if (!time.equals(other.time))
			return false;
		return true;
	}

}
