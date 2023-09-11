package com.jdbc.project;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class UI {

	private static ClientService clientService = new ClientServiceImpl();

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// registerClient();

		// readAllValue();

		searchByContactNo();

		// updateContactNo();

		// deleteClientbyContactNo();

	}

	private static void registerClient() throws ClassNotFoundException, SQLException {
		Scanner sc = new Scanner(System.in);

		System.out.println("Enter Client name");
		String name = sc.next();

		System.out.println("Enter the Gender(Select 0 for Male, 1 for Female and 2 for Others)");
		int genderId = sc.nextInt();
		Gender gender = null;
		if (genderId == 0) {
			gender = Gender.Male;
		} else if (genderId == 1) {
			gender = Gender.Female;
		} else if (genderId == 2) {
			gender = Gender.Other;
		}

		System.out.println("ENter the date of joining in YYYY/MM/DD format");
//		LocalDate doj=sc.locale();
		LocalDate doj = LocalDate.now();

		System.out.println("Enter the contact number");
		String contactNo = sc.next();

		System.out.println("Enter the emailID");
		String emailId = sc.next();

		System.out.println("Enter aadhar number");
		String aadharNo = sc.next();

		System.out.println("Enter pan number");
		String panNo = sc.next();

		System.out.println("Enter Address");
		String Address = sc.next();

		ClientDTO clientdto = new ClientDTO(name, gender, doj, contactNo, emailId, aadharNo, panNo, Address);
		clientdto = clientService.registerClient(clientdto);
		System.out.println("Client registered Successfully" + clientdto);
		sc.close();
	}

	public static void readAllValue() {
		List<ClientDTO> c = clientService.viewAllClients();
		for (ClientDTO cc : c) {
			System.out.println(cc);
		}
	}

	public static void searchByContactNo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the contact no of client");
		String no = scanner.next().trim();
		ClientDTO cd = clientService.searchClientByContactNo(no);
		System.out.println(cd);
		scanner.close();
	}

	public static void updateContactNo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the old contact no of client");
		String oldNo = scanner.next().trim();
		System.out.println("Please Enter the new contact no of client");
		String newNo = scanner.next().trim();
		String s = clientService.updateClientbyContactNo(oldNo, newNo);
		System.out.println(s);
		scanner.close();
	}

	public static void deleteClientbyContactNo() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Please Enter the contact no of client want to delete");
		String no = scanner.next().trim();
		String s = clientService.deleteClient(no);
		System.out.println(s);
	}
}
