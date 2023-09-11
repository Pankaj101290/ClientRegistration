package com.jdbc.project;

import java.sql.SQLException;
import java.util.List;

public interface ClientService {

	public ClientDTO registerClient(ClientDTO clientdto) throws ClassNotFoundException, SQLException;

	public List<ClientDTO> viewAllClients();

	public ClientDTO searchClientByContactNo(String contactNo);

	public String updateClientbyContactNo(String contactNo, String contactNoNew);

	public String deleteClient(String contactNo);
}
