package com.jdbc.project;

import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

public class ClientServiceImpl implements ClientService {
	private ClientRepository clientRepository = new ClientRepositoryImpl();

	@Override
	public ClientDTO registerClient(ClientDTO clientdto) throws ClassNotFoundException, SQLException {
		Client client = new Client();
		client.setClientId(clientdto.getClientId());
		client.setName(clientdto.getName());
		client.setGender(clientdto.getGender());
		client.setDoj(clientdto.getDoj());
		client.setContactNo(clientdto.getContactNo());
		client.setEmailID(clientdto.getEmailID());
		client.setAadharNo(clientdto.getAadharNo());
		client.setPanNo(clientdto.getPanNo());
		client.setAddress(clientdto.getAddress());
		clientRepository.insertClient(client);
		return clientdto;
	}

	@Override
	public String updateClientbyContactNo(String contactNo, String contactNoNew) {
		clientRepository.updateContactNo(contactNo, contactNoNew);
		return "contact no updated successfully...";
	}

	@Override
	public List<ClientDTO> viewAllClients() {
		return null;
//		List<Client> list = clientRepository.findAllClients();
//		if (list.isEmpty() | list == null)// || list == null
//			throw new RuntimeException("No Client found");
//		return list.stream()
//				.map(client -> new ClientDTO(client.getClientId(), client.getName(), client.getGender(),
//						client.getDoj(), client.getContactNo(), client.getEmailID(), client.getPanNo(),
//						client.getAadharNo(), client.getAddress()))
//			.collect(Collectors.toList());
	}

	@Override
	public ClientDTO searchClientByContactNo(String contactNo) {
		Client client = clientRepository.searchClientByContactNo(contactNo);
		if (client == null) {
			throw new RuntimeException("Client not found for phone number: " + contactNo);
		}
		return new ClientDTO(client.getClientId(), client.getName(), client.getGender(), client.getDoj(),
				client.getContactNo(), client.getEmailID(), client.getPanNo(), client.getAadharNo(),
				client.getAddress());
	}

	@Override
	public String deleteClient(String contactNo) {
		clientRepository.deleteClient(contactNo);
		return "Client deleted Successfully...";
	}

}
