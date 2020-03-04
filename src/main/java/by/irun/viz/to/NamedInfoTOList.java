package by.irun.viz.to;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Provides transfer-object for passing on front-end list of objects which can
 * be unite by name
 * <p>
 * this class - is not pojo-class
 * 
 * @author A.Dubovik
 *
 */
public class NamedInfoTOList<T> implements Iterable<T> {

	private String name;
	private List<T> infoTOs = new ArrayList<>();

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the infoTOs
	 */
	public List<T> getInfoTOs() {
		return infoTOs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable
	 */
	@Override
	public Iterator<T> iterator() {
		return infoTOs.iterator();
	}

	/**
	 * adds T into wrapped list
	 * 
	 * @param to
	 * @return
	 */
	public boolean add(T to) {
		return this.infoTOs.add(to);
	}

	/**
	 * returns T from wrapped list
	 * 
	 * @param i
	 * @return
	 */
	public T get(int i) {
		return this.infoTOs.get(i);
	}

	/**
	 * returns the size of wrapped list
	 * 
	 * @return size
	 */
	public int size() {
		return this.infoTOs.size();
	}
}
