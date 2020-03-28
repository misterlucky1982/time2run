package by.irun.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="CLUBS")
public class Club implements DomainEntity{

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column (name = "ID")
	private Long id;
	
	@Column (name = "NAME", nullable = false)
	private String name;
	
	@OneToMany(mappedBy="currentClub", targetEntity=by.irun.domain.Runner.class)
	private List<Runner>currentRunners;
	
	@ManyToOne(cascade= {CascadeType.REFRESH}, fetch=FetchType.LAZY)
    @JoinColumn(name="ADMIN", nullable = false, referencedColumnName = "ID")
	private User admin;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "SMALLLOGO", referencedColumnName = "ID")
	private Picture smallLogo;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "BIGLOGO", referencedColumnName = "ID")
	private Picture bigLogo;
	
	@Column(name = "BASECITY")
	private String baseCity;

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
	 * @return the currentRunners
	 */
	public List<Runner> getCurrentRunners() {
		return currentRunners;
	}

	/**
	 * @param currentRunners the currentRunners to set
	 */
	public void setCurrentRunners(List<Runner> currentRunners) {
		this.currentRunners = currentRunners;
	}

	/**
	 * @return the admin
	 */
	public User getAdmin() {
		return admin;
	}

	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(User admin) {
		this.admin = admin;
	}

	/**
	 * @return the smallLogo
	 */
	public Picture getSmallLogo() {
		return smallLogo;
	}

	/**
	 * @param smallLogo the smallLogo to set
	 */
	public void setSmallLogo(Picture smallLogo) {
		this.smallLogo = smallLogo;
	}

	/**
	 * @return the bigLogo
	 */
	public Picture getBigLogo() {
		return bigLogo;
	}

	/**
	 * @param bigLogo the bigLogo to set
	 */
	public void setBigLogo(Picture bigLogo) {
		this.bigLogo = bigLogo;
	}

	/**
	 * @return the baseCity
	 */
	public String getBaseCity() {
		return baseCity;
	}

	/**
	 * @param baseCity the baseCity to set
	 */
	public void setBaseCity(String baseCity) {
		this.baseCity = baseCity;
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
		Club other = (Club) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
}
