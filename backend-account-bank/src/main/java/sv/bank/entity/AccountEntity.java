package sv.bank.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Table(name = "BALANCE")
@Entity
@Getter
@Setter
@ToString
public class AccountEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Double saldo;
	@ManyToOne
	@JoinColumn(name = "cliente_id")
	private ClientEntity cliente;
    @OneToMany(mappedBy = "cuenta")
    private List<TransactionEntity> transacciones;
}
