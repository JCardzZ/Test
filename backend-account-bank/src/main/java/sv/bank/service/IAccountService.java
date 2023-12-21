package sv.bank.service;

import sv.bank.dto.AccountDTO;

public interface IAccountService {

	AccountDTO obtenerCuenta(Long clienteId);

}
