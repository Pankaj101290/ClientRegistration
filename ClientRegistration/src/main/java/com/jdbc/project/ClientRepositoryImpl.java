package com.jdbc.project;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ClientRepositoryImpl implements ClientRepository {

	@Override
	public Client insertClient(Client client) throws ClassNotFoundException, SQLException {
		Connection con = DBCon.connectDB();
		Statement st = con.createStatement();

		String query = "insert into client_details(name,gender,doj,contactNo,emailId,aadharNo,panNo,Address) values(\""
				+ client.getName() + "\",\"" + client.getGender() + "\",\"" + client.getDoj() + "\",\""
				+ client.getContactNo() + "\",\"" + client.getEmailID() + "\",\"" + client.getAadharNo() + "\",\""
				+ client.getPanNo() + "\",\"" + client.getAddress() + "\");";
		System.out.println(query);
		st.executeUpdate(query);

		try {
			if (con != null || !con.isClosed()) {
				con.close();
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return client;
	}

	@Override
	public List<Client> findAllClients() {
		List<Client> list = new ArrayList<Client>();
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String query = "select * from client_details;";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);
			while (rs.next()) {
				Client client = new Client();

				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date date = rs.getDate("doj");
				String contactNo = rs.getString("contactNo");
				String emailId = rs.getString("emailId");
				String panNo = rs.getString("panNo");
				String aadharNo = rs.getString("aadharNo");
				String address = rs.getString("address");

				client.setClientId(id);
				client.setName(name);
				if (gender.equalsIgnoreCase("male")) {
					client.setGender(Gender.Male);
				} else if (gender.equalsIgnoreCase("female")) {
					client.setGender(Gender.Female);
				} else if (gender.equalsIgnoreCase("other")) {
					client.setGender(Gender.Other);
				}
				LocalDate date1 = LocalDate.parse(date.toString());
				client.setDoj(date1);
				client.setContactNo(contactNo);
				client.setEmailID(emailId);
				client.setPanNo(panNo);
				client.setAadharNo(aadharNo);
				client.setAddress(address);

				list.add(client);
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null || !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return list;
	}

	@Override
	public Client searchClientByContactNo(String contactNo) {
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			// String query = String.format("SELECT * FROM mydb.client_details where
			// contactNo=\"%S\";", contactNo);
			String query = "SELECT * FROM mydb.client_details where contactNo='" + contactNo + "';";
			System.out.println(query);
			ResultSet rs = st.executeQuery(query);

			if (rs.next()) {
				Client client = new Client();
				Integer id = rs.getInt("id");
				String name = rs.getString("name");
				String gender = rs.getString("gender");
				Date date = rs.getDate("doj");
				String contactNo1 = rs.getString("contactNo");
				String emailId = rs.getString("emailId");
				String panNo = rs.getString("panNo");
				String aadharNo = rs.getString("aadharNo");
				String address = rs.getString("address");

				client.setClientId(id);
				client.setName(name);
				if (gender.equalsIgnoreCase("male")) {
					client.setGender(Gender.Male);
				} else if (gender.equalsIgnoreCase("female")) {
					client.setGender(Gender.Female);
				} else if (gender.equalsIgnoreCase("other")) {
					client.setGender(Gender.Other);
				}
				LocalDate date1 = LocalDate.parse(date.toString());
				client.setDoj(date1);
				client.setContactNo(contactNo1);
				client.setEmailID(emailId);
				client.setPanNo(panNo);
				client.setAadharNo(aadharNo);
				client.setAddress(address);
				return client;
			}
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (con != null | !con.isClosed()) {
					con.close();
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		return null;
	}

	@Override
	public void updateContactNo(String contactNo, String contactNoNew) {
		Connection con = null;
		try {
			con = DBCon.connectDB();
			Statement st = con.createStatement();
			String queryString = String.format("update client_details set contactNo=\"%s\"where contactNo=\"%s\";",
					contactNoNew, contactNo);
			if (contactNo.equals(contactNoNew)) {
				System.out.println();
			}
			System.out.println(queryString);
			st.executeUpdate(queryString);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void deleteClient(String contactNo) {
		Connection connection = null;
		try {
			connection = DBCon.connectDB();
			Statement st = connection.createStatement();
			String query = String.format("delete from client_details where contactNo=\"%s\";", contactNo);
			System.out.println(query);
			st.execute(query);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
