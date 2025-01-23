<%@ page import ="models.Cafe" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<html>
<head>
    <title>Cafes</title>
</head>
<style>
    .tabBorder{
        border : 1px solid black ;
    }
</style>
<body>

<h2>Liste des Cafes</h2>


    <%
        List<Cafe> cafes = (List<Cafe>) request.getAttribute("cafes");
            if (cafes != null && !cafes.isEmpty()) {
    %>

<table class="tabBorder">
    <tr>
        <th class="tabBorder">NOM_ CAFE</th>
        <th class="tabBorder">FO_ID</th>
        <th class="tabBorder">Prix</th>
        <th class="tabBorder">Ventes</th>
        <th class="tabBorder">Action</th>
    </tr>

        <%
            for (Cafe cafe : cafes) {
        %>

    <tr>
        <td class="tabBorder"><%= cafe.getNom() %></td>
        <td class="tabBorder"><%= cafe.getFoId() %></td>
        <td class="tabBorder"><%= cafe.getPrix() %></td>
        <td class="tabBorder"><%= cafe.getVentes() %></td>

        <td class="tabBorder">

            <form action="servletSuppCafe" method="POST">

                <input type="hidden" name="cafeId" value="<%= cafe.getNom() %>">
                <input type="submit" value="Supprimer">

            </form>

        </td>

    </tr>

    <%
                }
        } else {
    %>

    <tr><td colspan="5">Aucun café disponible</td></tr>

    <%
        }
    %>

</table>

<br>

<form action="AjouterCafe" method="GET">
    <button type="submit">Ajouter un nouveau cafe</button>
</form>

<br><br>
<a href="index.jsp">Retour</a>


</body>
</html>