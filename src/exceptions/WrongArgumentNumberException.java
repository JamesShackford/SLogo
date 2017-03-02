package exceptions;

/**
 * A subclass of SyntaxException thrown when too few arguments are provided
 * for a command. Typically, providing too many is not an error: example,
 * fd 50 60 parses to 50 60, which is left as an acceptable expression.
 * @author Matthew Barbano
 *
 */
public class WrongArgumentNumberException extends SyntaxException{
	private static final long serialVersionUID = 1L;
	
	public WrongArgumentNumberException(String instructionSpecificErrorName){
		super(instructionSpecificErrorName);
	}
	
	public WrongArgumentNumberException(Throwable cause){
		super(cause);
	}
	
	public WrongArgumentNumberException(String errorReport, Throwable cause){
		super(errorReport, cause);
	}

}
