<%@ page pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<p class="info">${ message }</p>
    	<p>Client</p>
		<p>Nom : ${ commande.client.cliNom }</p>
		<p>Prénom : ${ commande.client.cliPrenom }</p>
		<p>Adresse : ${ commande.client.cliAdresseLivraison }</p>
		<p>Numéro de téléphone : ${ commande.client.cliNumTel }</p>
		<p>Email : ${ commande.client.cliEmail }</p>
		<p>Commande</p>
		<p>Date : ${ commande.dateCommande }</p>
		<p>Montant : ${ commande.montantCommande }</p>
		<p>Mode de paiement : ${ commande.modePaiementCommande }</p>
		<p>Statut du paiement : ${ commande.statutPaiementCommande }</p>
		<p>Mode de livraison : ${ commande.modeLivraisonCommande }</p>
		<p>Statut de la livraison : ${ commande.statutLivraisonCommande }</p>
	</body>
</html>