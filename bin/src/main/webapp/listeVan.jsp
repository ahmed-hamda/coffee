<%@ page import ="models.Viennoiserie" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
    <title>Viennoiseries</title>
</head>
<style>
    .tabBorder{
        border : 1px solid black ;
    }
</style>
<body>

<h2>Liste des Viennoiseries</h2>

<table class="tabBorder">
    <tr>
        <th class="tabBorder">NOM_ Viennoiserie</th>
        <th class="tabBorder">FO_ID</th>
        <th class="tabBorder">Prix</th>
        <th class="tabBorder">Ventes</th>
        <th class="tabBorder">Action</th>
    </tr>

    <%// Récupérer la liste des viennoiseries passée depuis le servlet
        List<Viennoiserie> viennoiseries = (List<Viennoiserie>) request.getAttribute("viens");
        if (viennoiseries != null && !viennoiseries.isEmpty()) {
            // Parcourir la liste de viennoiseries
            for (Viennoiserie viennoiserie : viennoiseries) {
    %>
    <tr>
        <td class="tabBorder" ><%= viennoiserie.getNom() %></td>
        <td class="tabBorder" ><%= viennoiserie.getFoId() %></td>
        <td class="tabBorder"><%= viennoiserie.getPrix() %></td>
        <td class="tabBorder"><%= viennoiserie.getVentes() %></td>

        <td class="tabBorder">

            <form  action="servletSuppVan" method="POST">

                <input type="hidden" name="VanId" value="<%= viennoiserie.getNom() %>">
                <input type="submit" value="Supprimer">

            </form>

        </td>
    </tr>
    <% } %>
</table>
<%
} else {
%>
<p>Aucune viennoiserie à afficher.</p>
<%
    }
%>

<br>
<form action="AjoutVan" method="GET">
    <button type="submit">Ajouter un nouveau viennoiserie</button>
</form>
<br><br>
<a href="index.jsp">Retour</a>

</body>
</html>



