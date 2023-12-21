package sv.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import sv.bank.dto.ResponseMessage;
import sv.bank.dto.TransactionRequestDTO;
import sv.bank.service.impl.TransactionService;
import sv.bank.util.AppConstants;

@Slf4j
@RestController
@RequestMapping("/transacciones")
@Validated
public class TransactionController {

	@Autowired
	private TransactionService transactionService;

	@Operation(summary = "Microservicio que Permite la Consulta de Transacciones del Cliente", description = "consulta-cuenta")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = AppConstants.API_RESPONSE_CODE_OK_VALUE, content = @Content(schema = @Schema(implementation = TransactionRequestDTO.class))),
			@ApiResponse(responseCode = "400", description = AppConstants.API_RESPONSE_CODE_BAD_REQUEST_VALUE, content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
			@ApiResponse(responseCode = "409", description = AppConstants.API_RESPONSE_CODE_CONFLICT_VALUE, content = @Content(schema = @Schema(implementation = ResponseMessage.class))),
			@ApiResponse(responseCode = "500", description = AppConstants.API_RESPONSE_CODE_INTERNAL_SERVER_ERROR_VALUE, content = @Content(schema = @Schema(implementation = ResponseMessage.class))) })
	@PostMapping("/credit")
	public ResponseEntity<String> creditTransaction(@RequestBody TransactionRequestDTO requestDTO) {
		log.info("[>>> INICIA CREDIT TRANSACTION <<<]");
		transactionService.processTransaction(requestDTO);
		return ResponseEntity.ok("Transacción completada exitosamente");
	}
}
