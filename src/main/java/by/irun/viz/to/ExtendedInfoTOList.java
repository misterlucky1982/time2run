package by.irun.viz.to;
/**
 * Extended NamedList with additional properties
 * @author A.Dubovik
 *
 * @param <T>
 */
public class ExtendedInfoTOList<T> extends NamedInfoTOList<T>{

	private String link;

	/**
	 * @return the link
	 */
	public String getLink() {
		return link;
	}

	/**
	 * @param link the link to set
	 */
	public void setLink(String link) {
		this.link = link;
	}
	
}
