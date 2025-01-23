<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<h2>Bienvenue, Administrateur</h2>

<h3>Gérer les cafés</h3>
<ul>
    <li><a href="<%= request.getContextPath() %>/cafes" style="text-decoration: none;" >Liste des cafés</a></li>

</ul>

<h3>Gérer les viennoiseries</h3>
<ul>
    <li><a href="<%= request.getContextPath() %>/viennoiseries" style="text-decoration: none;" >Liste des viennoiseries</a></li>

</ul>





</body>
</html>

