package com.sdzee.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Client;

public class CreationClient extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String cliNom = new String(request.getParameter("nomClient").getBytes("8859_1"));
		String cliPrenom = new String(request.getParameter("prenomClient").getBytes("8859_1"));
		String cliAdresse = new String(request.getParameter("adresseClient").getBytes("8859_1"));
		String cliTel = new String(request.getParameter("telephoneClient").getBytes("8859_1"));
		String cliEmail = new String(request.getParameter("emailClient").getBytes("8859_1"));
		
		String message = "";
		Client client = new Client();
		
		if((cliNom.trim() == "") || (cliAdresse.trim() == "") || (cliTel.trim() == "")) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.<br>" +
					"<a href=\"creerClient.jsp\">Cliquez ici</a> pour accéder au formulaire de " +
					"création d'un client.";
		}	
		else {
			message = "Client créé avec succès.";
			System.out.println(cliPrenom);
		}
		
		client.setCliNom(cliNom);
		client.setCliPrenom(cliPrenom);
		client.setCliEmail(cliEmail);
		client.setCliNumTel(cliTel);
		client.setCliAdresseLivraison(cliAdresse);
		
		request.setAttribute("client", client);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher("/afficherClient.jsp").forward(request, response);
	}
}
