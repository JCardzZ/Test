package sv.bank.exception;

import sv.bank.dto.ResponseMessage;

public class BankAppException extends RuntimeException {
	
	private static final long serialVersionUID = 7838983426357318937L;

	private final ResponseMessage error;

	public BankAppException(ResponseMessage error) {
		super(error.getMessage());
		this.error = error;
	}

	public ResponseMessage getError() {
		return error;
	}

}
