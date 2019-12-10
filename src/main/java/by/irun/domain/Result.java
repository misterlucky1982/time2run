package by.irun.domain;

import java.time.Duration;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import by.irun.persistance.util.DurationConverter;
import by.irun.persistance.util.GenderConverter;

@Entity
@Table(name="RESULT")
public class Result implements DomainEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column (name = "ID")
	private Long id;
	
	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="RACE", referencedColumnName = "ID")
	private Race race;
	
	@Column(name="POSITION")
	private int absolutePosition;
	
	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="RUNNER", referencedColumnName = "ID")
	private Runner runner;
	
	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="CLUB", referencedColumnName = "ID")
	private Club club;
	
	@Column(name = "GENDER")
	@Convert(converter = GenderConverter.class)
	private Gender gender;
	
	@Column(name = "TIME")
	@Convert(converter = DurationConverter.class)
	private Duration time;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the race
	 */
	public Race getRace() {
		return race;
	}
	/**
	 * @param race the race to set
	 */
	public void setRace(Race race) {
		this.race = race;
	}
	/**
	 * @return the absolutePosition
	 */
	public int getAbsolutePosition() {
		return absolutePosition;
	}
	/**
	 * @param absolutePosition the absolutePosition to set
	 */
	public void setAbsolutePosition(int absolutePosition) {
		this.absolutePosition = absolutePosition;
	}
	/**
	 * @return the runner
	 */
	public Runner getRunner() {
		return runner;
	}
	/**
	 * @param runner the runner to set
	 */
	public void setRunner(Runner runner) {
		this.runner = runner;
	}
	/**
	 * @return the club
	 */
	public Club getClub() {
		return club;
	}
	/**
	 * @param club the club to set
	 */
	public void setClub(Club club) {
		this.club = club;
	}
	/**
	 * @return the gender
	 */
	public Gender getGender() {
		return gender;
	}
	/**
	 * @param gender the gender to set
	 */
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	/**
	 * @return the time
	 */
	public Duration getTime() {
		return time;
	}
	/**
	 * @param time the time to set
	 */
	public void setTime(Duration time) {
		this.time = time;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Result other = (Result) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
