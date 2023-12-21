package sv.bank.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.bank.dto.ResponseMessage;
import sv.bank.dto.TransactionRequestDTO;
import sv.bank.entity.AccountEntity;
import sv.bank.entity.ClientEntity;
import sv.bank.entity.TransactionEntity;
import sv.bank.exception.BankAppException;
import sv.bank.repository.AccountRepository;
import sv.bank.repository.ClienteRepository;
import sv.bank.repository.TransactionRepository;
import sv.bank.service.ITransactionService;
import sv.bank.util.AppConstants;

@Service
public class TransactionService implements ITransactionService {
	@Autowired
	private ClienteRepository clientRepository;

	@Autowired
	private AccountRepository accountRepository;

	@Autowired
	private TransactionRepository transactionRepository;

	@Override
	public void processTransaction(TransactionRequestDTO req) throws BankAppException {
		// Validar ID del cliente
		if (req.getClientId() == null) {

			throw new BankAppException(
					new ResponseMessage(AppConstants.CODE_ERROR_INTERNAL, 6L, AppConstants.ID_NOT_FOUND));
		}

		// Obtener cliente
		Long clientId = req.getClientId();
		ClientEntity client = clientRepository.findById(clientId)
				.orElseThrow(() -> new IllegalArgumentException("Cliente no encontrado con ID: " + clientId));

		// Validar ID de la cuenta
		if (req.getAccountId() == null) {
			throw new BankAppException(
					new ResponseMessage(AppConstants.CODE_ERROR_INTERNAL, 7L, AppConstants.ACCOUNT_NULL));

		}
		// Obtener o guardar cuenta
		AccountEntity account = accountRepository.findById(req.getAccountId()).orElseGet(() -> {
			AccountEntity newAccount = new AccountEntity();
			newAccount.setCliente(client);
			return accountRepository.save(newAccount); // Guardar la nueva cuenta en el repositorio
		});

		// Crear transacción
		TransactionEntity transaction = new TransactionEntity();
		transaction.setFecha(new Date());
		transaction.setMonto(req.getAmount());

		// Establecer relación con la cuenta
		transaction.setCuenta(account);

		// Actualizar saldo de la cuenta
		Double newBalance = account.getSaldo() + req.getAmount();
		account.setSaldo(newBalance);

		// Guardar cambios
		accountRepository.save(account);
		transactionRepository.save(transaction);
	}
}
