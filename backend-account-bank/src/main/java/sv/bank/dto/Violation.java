package sv.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Violation {

	private String fieldName;
	private String message;
	
}
