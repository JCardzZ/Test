package sv.bank.service;

import sv.bank.dto.TransactionRequestDTO;

public interface ITransactionService {

	public void processTransaction(TransactionRequestDTO req) throws Exception;
}
