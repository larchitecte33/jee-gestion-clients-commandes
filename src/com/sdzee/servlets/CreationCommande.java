package com.sdzee.servlets;

import java.io.IOException;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sdzee.beans.Client;
import com.sdzee.beans.Commande;

import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

public class CreationCommande extends HttpServlet {
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws 
		ServletException, IOException {
		String cliNom = request.getParameter("nomClient");
		String cliPrenom = request.getParameter("prenomClient");
		String cliAdresse = request.getParameter("adresseClient");
		String cliTel = request.getParameter("telephoneClient");
		String cliEmail = request.getParameter("emailClient");
		
		/* Récupération de la date courante */
		DateTime dateCourante = new DateTime();
		
		/* Convertion de la date en string */
		org.joda.time.format.DateTimeFormatter formatter = DateTimeFormat.forPattern("dd/MM/yyyy HH:mm:ss");
		String comDate = dateCourante.toString(formatter);
		
		boolean isMontantRempli = true;
		double comMontant = 0;
		
		try {
			comMontant = Float.valueOf(request.getParameter("montantCommande"));
		}
		catch(NumberFormatException nfe) {
			isMontantRempli = false;
		}
		
		String comModePaiement = request.getParameter("modePaiementCommande");
		String comStatutPaiement = request.getParameter("statutPaiementCommande");
		String comModeLivraison = request.getParameter("modeLivraisonCommande");
		String comStatutLivraison = request.getParameter("statutLivraisonCommande");
		
		String message = "";
		Client client = new Client();
		Commande commande = new Commande();
		
		if((cliNom.trim() == "") || (cliAdresse.trim() == "") || (cliTel.trim() == "")
				|| (!isMontantRempli) || (comModePaiement.trim() == "") 
				|| (comModeLivraison.trim() == "")) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires.<br>" +
					"<a href=\"creerCommande.jsp\">Cliquez ici</a> pour accéder au formulaire de " +
					"création d'une commande.";
		}	
		else {
			message = "Commande créée avec succès.";
		}
		
		client.setCliNom(cliNom);
		client.setCliPrenom(cliPrenom);
		client.setCliEmail(cliEmail);
		client.setCliNumTel(cliTel);
		client.setCliAdresseLivraison(cliAdresse);
		
		commande.setClient(client);
		commande.setDateCommande(comDate);
		commande.setModeLivraisonCommande(comModeLivraison);
		commande.setModePaiementCommande(comModePaiement);
		commande.setMontantCommande(comMontant);
		commande.setStatutLivraisonCommande(comStatutLivraison);
		commande.setStatutPaiementCommande(comStatutPaiement);
		
		request.setAttribute("commande", commande);
		request.setAttribute("message", message);
		
		this.getServletContext().getRequestDispatcher("/afficherCommande.jsp").forward(request, response);
	}
}
