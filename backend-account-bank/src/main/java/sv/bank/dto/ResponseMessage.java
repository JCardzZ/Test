package sv.bank.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ResponseMessage implements Serializable {

	private static final long serialVersionUID = 2550044282850356242L;
	
	@JsonIgnore
	private Long codeStatus;
	private Long code;
	private String message;
}
