package sv.bank.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.bank.entity.AccountEntity;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
	
    Optional<AccountEntity> findByCliente_Id(Long clienteId);


}
