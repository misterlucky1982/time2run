package by.irun.util;
/**
 * Wrapper-class for {@link java.util.List}
 * @author A.Dubovik
 *
 */
public class List<T> {
	
	private java.util.List<T> list;

	/**
	 * @return the list
	 */
	public java.util.List<T> getList() {
		return list;
	}

	/**
	 * @param list the list to set
	 */
	public void setList(java.util.List<T> list) {
		this.list = list;
	}
	
	
}
