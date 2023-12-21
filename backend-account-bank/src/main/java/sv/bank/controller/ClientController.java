package sv.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

import sv.bank.dto.ClienteDTO;
import sv.bank.service.IClientService;
import sv.bank.util.AppConstants;
import sv.bank.util.WebUtils;

@Slf4j
@RestController
@RequestMapping("/clientes")
@Validated
public class ClientController {

	@Autowired
	private WebUtils webUtils;

	@Autowired
	private IClientService clienteService;

	@GetMapping("/{clienteId}")
	public ResponseEntity<?> obtenerCliente(@PathVariable(name = "clienteId") Long clienteId) {
		log.info("[>>> INICIA CONSULTA DE CLIENTE <<<]");
		ClienteDTO clienteDTO = clienteService.getClienteById(clienteId);
		return webUtils.createCustomizedResponse(clienteDTO, AppConstants.CODE_SUCCESS);
	}
}
