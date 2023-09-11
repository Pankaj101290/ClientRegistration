package com.jdbc.project;

import java.sql.SQLException;
import java.util.List;

public interface ClientRepository {

	public Client insertClient(Client client) throws ClassNotFoundException, SQLException;

	public List<Client> findAllClients();

	public Client searchClientByContactNo(String contactNo);

	public void updateContactNo(String contactNo, String contactNoNew);

	public void deleteClient(String contactNo);
}
