package edu.sf.ebolt.exception;

public class RecordNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	public RecordNotFoundException() {

	}

	public RecordNotFoundException(String message) {
		super(message);
	}

}
