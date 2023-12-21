package sv.bank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import sv.bank.entity.AccountEntity;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class AccountDTO {

	
    private Long id;
    private Double saldo;
    
    public AccountDTO(AccountEntity account) {
        this.id = account.getId();
        this.saldo = account.getSaldo();
    }
}
