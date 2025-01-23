<%@ page import="models.Viennoiserie" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>

<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    
    <title>Liste des Viennoiseries</title>
    <style>
           body {
            font-family: Arial, sans-serif;       
            background-image: url('images/croissant111.jpg'); /* Image de fond pour le body */
            margin: 0;
            padding: 0;
            background-size: cover;
            background-position: center;
            background-repeat: no-repeat;
            color: #333;
            height: 100vh; 
            
        }
        body {
		    font-family: Arial, sans-serif;
		    margin: 0;
		    padding: 0;
		    background-color: #f4f4f9;
		    color: #333;
		    display: flex; /* Utilisation de Flexbox */
		    justify-content: center; /* Centre horizontalement */
		    align-items: center; /* Centre verticalement */
		    height: 100vh; /* La hauteur de la fenêtre */
		}
       
  main {
           
            background-color: rgba(255, 255, 255, 0.8); /* Fond blanc semi-transparent */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 800px; /* Largeur du formulaire */
            text-align: center;
        
        }
        h2 {
            margin: 1rem 0;
            text-align: center;
            color: black;
        }

        table {
            width: 80%;
            margin: 2rem auto;
            border-collapse: collapse;
            background-color: white;
            box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
        }

        table, th, td {
            border: 1px solid #ddd;
        }

        th, td {
            padding: 1rem;
            text-align: center;
        }

        th {
            background-color: #4CAF50;
            color: white;
        }

        tr:nth-child(even) {
            background-color: #f9f9f9;
        }

        tr:hover {
            background-color: #f1f1f1;
        }

        .actions {
            display: flex;
            justify-content: center;
            gap: 0.5rem;
        }

        form {
            margin: 0;
        }

        form button, input[type="submit"] {
            background-color: #f44336;
            color: white;
            border: none;
            padding: 0.5rem 1rem;
            cursor: pointer;
            border-radius: 4px;
            font-size: 0.9rem;
        }

        form button:hover, input[type="submit"]:hover {
            background-color: #d32f2f;
        }

        .add-btn {
            display: block;
            width: fit-content;
            margin: 1rem auto;
            padding: 0.5rem 1.5rem;
            background-color: #4CAF50;
            color: white;
            border: none;
            border-radius: 4px;
            text-decoration: none;
            font-size: 1rem;
            text-align: center;
        }

        .add-btn:hover {
            background-color: #45a049;
        }

        footer {
            text-align: center;
          
            color: #777;
            font-size: 0.9rem;
        }

        .return-link {
            display: inline-block;
            margin: 1rem auto;
            color: #4CAF50;
            text-decoration: none;
            font-weight: bold;
            padding: 0.5rem 1rem;
            border: 1px solid #4CAF50;
            border-radius: 4px;
            transition: all 0.3s ease;
            text-align: center;
        }

        .return-link:hover {
            background-color: #4CAF50;
            color: white;
        }

        .container {
            text-align: center;
        }
    </style>
</head>
<body>

    

<%
    List<String> notifications = (List<String>) session.getAttribute("notifications");
    if (notifications != null) {
        session.removeAttribute("notifications"); // Supprimer après affichage
    }
%>

<% if (notifications != null && !notifications.isEmpty()) { %>
    <div id="notification-container" class="alert alert-success alert-dismissible fade show position-fixed top-0 end-0 m-3" role="alert">
        <ul class="list-unstyled mb-0">
            <% for (String notification : notifications) { %>
                <li><%= notification %></li>
            <% } %>
        </ul>
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>
    </div>
    
    <script>
        // JavaScript pour masquer la notification après 5 secondes
        setTimeout(function() {
            var notificationElement = document.getElementById("notification-container");
            if (notificationElement) {
                notificationElement.classList.remove("show"); // Ajout d'un effet de disparition Bootstrap
                setTimeout(function() {
                    notificationElement.remove(); // Supprime l'élément du DOM après l'effet
                }, 150); // Délai pour permettre à l'effet Bootstrap de s'appliquer
            }
        }, 5000); // Délai de 5 secondes
    </script>
<% } %>


<main>
    <%
        List<Viennoiserie> viennoiseries = (List<Viennoiserie>) request.getAttribute("viens");
        if (viennoiseries != null && !viennoiseries.isEmpty()) {
    %>
    <h2>Liste des Viennoiseries</h2>
    <table>
        <thead>
            <tr>
                <th>Nom de la Viennoiserie</th>
                <th>FO_ID</th>
                <th>Prix</th>
                <th>Ventes</th>
                <th>Action</th>
            </tr>
        </thead>
        <tbody>
            <%
                for (Viennoiserie viennoiserie : viennoiseries) {
            %>
            <tr>
                <td><%= viennoiserie.getNom() %></td>
                <td><%= viennoiserie.getFoId() %></td>
                <td><%= viennoiserie.getPrix() %></td>
                <td><%= viennoiserie.getVentes() %></td>
                <td>
                    <div class="actions">
                        <form action="servletSuppVan" method="POST">
                            <input type="hidden" name="VanId" value="<%= viennoiserie.getNom() %>">
                            <input type="submit" value="Supprimer">
                        </form>
                    </div>
                </td>
            </tr>
            <%
                }
            %>
        </tbody>
    </table>
    <%
        } else {
    %>
    <p style="text-align: center; margin-top: 2rem;">Aucune viennoiserie disponible.</p>
    <% 
        }
    %>

    
    <a href="AjoutVan" class="add-btn">Ajouter une nouvelle viennoiserie</a>
    <div class="container">
        <a href="index.jsp" class="return-link">Retour à l'accueil</a>
    </div>
    <footer>
    	© 2024 - Gestion des Viennoiseries
    </footer>
</main>



</body>
</html>
