package sv.bank.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.bank.entity.TransactionEntity;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {
	List<TransactionEntity> findByCuenta_Cliente_Id(Long clienteId);
}
