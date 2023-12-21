package sv.bank.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ValidationErrorResponse extends ResponseMessage {

	private static final long serialVersionUID = -7981921195275686885L;

	public ValidationErrorResponse(Long status, Long code, String message) {
		super(status, code, message);
	}

	private transient List<Violation> violations = new ArrayList<>();

}
