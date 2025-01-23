<%--
  Created by IntelliJ IDEA.
  User: msi
  Date: 02/12/2024
  Time: 02:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h2>Ajouter un nouveau café</h2>

<form action="AjouterCafe" method="POST">

    <label for="cafeName">Nom du café :</label>
    <input type="text" id="cafeName" name="cafeName"  required><br><br>

    <label for="FoID">Fornisseur ID :</label>
    <input type="text" id="FoID" name="FoID"  required><br><br>

    <label for="prix">Prix :</label>
    <input type="text" id="prix" name="prix"  required><br><br>


    <label for="ventes">Ventes :</label>
    <input type="text" id="ventes" name="ventes" required><br><br>

    <input type="submit" value="Ajouter">

</form>

<form action="cafes" method="GET">

    <input type="submit" value="Retour">

</form>




</body>
</html>
