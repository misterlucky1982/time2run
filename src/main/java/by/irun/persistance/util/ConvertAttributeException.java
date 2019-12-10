package by.irun.persistance.util;

import javax.persistence.PersistenceException;

public class ConvertAttributeException extends PersistenceException{
	
	private static final long serialVersionUID = 1L;
	public ConvertAttributeException(){}
	public ConvertAttributeException(String message){
		super(message);
	}
}
