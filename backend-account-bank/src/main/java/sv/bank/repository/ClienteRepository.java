package sv.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import sv.bank.entity.ClientEntity;

public interface ClienteRepository extends JpaRepository<ClientEntity, Long> {

}
