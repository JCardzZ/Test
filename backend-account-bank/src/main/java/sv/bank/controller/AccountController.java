package sv.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import sv.bank.dto.AccountDTO;
import sv.bank.service.IAccountService;

@Slf4j
@RestController
@RequestMapping("/account")
@Validated
public class AccountController {

	@Autowired
	private IAccountService cuentaService;

	@GetMapping("/{clienteId}")
	public AccountDTO obtenerCuenta(@PathVariable Long clienteId) {
		log.info("[>>> INICIA CONSULTA DE CUENTA <<<]");
		return cuentaService.obtenerCuenta(clienteId);
	}
}
