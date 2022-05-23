<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <%@ page contentType="text/html; charset=UTF-8" %>
        <%@ page pageEncoding="UTF-8" %>
        <title>Création d'un client</title>
        <link type="text/css" rel="stylesheet" href="inc/style.css" />
    </head>
    <body>
    	<p class="info">${ message }</p>
		<p>Nom : ${ client.cliNom }</p>
		<p>Prénom : ${ client.cliPrenom }</p>
		<p>Adresse : ${ client.cliAdresseLivraison }</p>
		<p>Numéro de téléphone : ${ client.cliNumTel }</p>
		<p>Email : ${ client.cliEmail }</p>
	</body>
</html>