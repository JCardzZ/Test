package sv.bank.service.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;

import sv.bank.dto.AccountDTO;
import sv.bank.entity.AccountEntity;
import sv.bank.repository.AccountRepository;
import sv.bank.service.IAccountService;

@Service
public class AccountServiceImpl implements IAccountService {

	private final AccountRepository accountRepository;

	
	public AccountServiceImpl(AccountRepository accountRepository) {
		this.accountRepository = accountRepository;
	}

	@Override
	public AccountDTO obtenerCuenta(Long clienteId) {
		Optional<AccountEntity> accountOptional = accountRepository.findByCliente_Id(clienteId);

		if (accountOptional.isPresent()) {
			AccountEntity account = accountOptional.get();
			return new AccountDTO(account);
		} else {
			return null;
		}
	}
}
