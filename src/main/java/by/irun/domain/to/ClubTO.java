package by.irun.domain.to;

/**
 * This class provides object for transfer club`s data between entity-layer and viz-layer
 * @author A.Dubovik
 */
public class ClubTO {
	
	/**
	 * Official name of the club
	 */
	String name;
	/**
	 * The base city of the club
	 */
	String city;
	/**
	 * First race id
	 */
	Long firstRace;
	/**
	 * Admin`s email
	 */
	String email;
	/**
	 * Admin`s phone
	 */
	String phone;
	/**
	 * Logo`s url (path)
	 */
	String clubLogo;
	/**
	 * @return the name
	 */
	protected String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the city
	 */
	protected String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	protected void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the firstRace
	 */
	protected Long getFirstRace() {
		return firstRace;
	}
	/**
	 * @param firstRace the firstRace to set
	 */
	protected void setFirstRace(Long firstRace) {
		this.firstRace = firstRace;
	}
	/**
	 * @return the email
	 */
	protected String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	protected void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	protected String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	protected void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the clubLogo
	 */
	protected String getClubLogo() {
		return clubLogo;
	}
	/**
	 * @param clubLogo the clubLogo to set
	 */
	protected void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}
	
	
}
