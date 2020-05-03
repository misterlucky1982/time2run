package by.irun.util;

/**
 * Provides key-value object for pass to UI 
 * @author A.Dubovik
 *
 */
public class IdItem {
	
	private String id;
	private String name;
	
	public IdItem(){}
	
	public IdItem(Long idL, String name){
		this.id = Long.toString(idL);
		this.name = name;
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
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
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = Long.toString(id);
	}

}
