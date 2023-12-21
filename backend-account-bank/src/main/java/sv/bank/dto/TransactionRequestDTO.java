package sv.bank.dto;

import java.util.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class TransactionRequestDTO {

	private Long clientId;
	private Long accountId;
	private Double amount;
	private Date created;
}
