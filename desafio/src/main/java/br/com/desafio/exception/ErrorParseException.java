package br.com.desafio.exception;

public class ErrorParseException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6662179173760676470L;

	public ErrorParseException() {
		super();
	}

	public ErrorParseException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ErrorParseException(String message, Throwable cause) {
		super(message, cause);
	}

	public ErrorParseException(String message) {
		super(message);
	}

	public ErrorParseException(Throwable cause) {
		super(cause);
	}

}
