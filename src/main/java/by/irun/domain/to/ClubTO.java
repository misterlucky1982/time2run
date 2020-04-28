package by.irun.domain.to;

/**
 * This class provides object for transfer club`s data between entity-layer and viz-layer
 * @author A.Dubovik
 */
public class ClubTO {
	
	/**
	 * Official name of the club
	 */
	private String name;
	/**
	 * The base city of the club
	 */
	private String city;
	/**
	 * Admin`s email
	 */
	private String email;
	/**
	 * Admin`s phone
	 */
	private String phone;
	/**
	 * Logo`s url (path)
	 */
	private String clubLogo;
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
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the clubLogo
	 */
	public String getClubLogo() {
		return clubLogo;
	}
	/**
	 * @param clubLogo the clubLogo to set
	 */
	public void setClubLogo(String clubLogo) {
		this.clubLogo = clubLogo;
	}
	
	
}
