package sv.bank.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sv.bank.dto.ClienteDTO;
import sv.bank.dto.ResponseMessage;
import sv.bank.entity.ClientEntity;
import sv.bank.exception.BankAppException;
import sv.bank.repository.ClienteRepository;
import sv.bank.service.IClientService;
import sv.bank.util.AppConstants;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClienteRepository clientRepository;

	private ClienteDTO convertToDto(ClientEntity client) {

		ClienteDTO clientDTO = new ClienteDTO();
		clientDTO.setId(client.getId());
		clientDTO.setName(client.getName());
		clientDTO.setLast_name(client.getLast_name());
		return clientDTO;
	}


	 @Override
	    public ClienteDTO getClienteById(Long clienteId) {
	        Optional<ClientEntity> clientOptional = clientRepository.findById(clienteId);
	        if (clientOptional.isPresent()) {
	            return convertToDto(clientOptional.get());
	        } else {
	        	throw new BankAppException(
						new ResponseMessage(AppConstants.CODE_ERROR_INTERNAL, 5L, AppConstants.CLIENT_NOT_FOUND));
	        }
	    }
}
