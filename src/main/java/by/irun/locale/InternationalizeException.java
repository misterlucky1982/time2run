package by.irun.locale;

public class InternationalizeException extends RuntimeException{

	/**
	 * Exception which can happen during internationalization
	 */
	private static final long serialVersionUID = 1L;
	
	public InternationalizeException(){}
	
	public InternationalizeException(String message){
		super(message);
	}

}
