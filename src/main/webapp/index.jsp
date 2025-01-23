<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Administration</title>
    <style>
         body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-image: url('images/coffee33.png'); /* Image de fond pour le body */
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

		html, body {
		
		    height: 100%; /* Assure que html et body occupent toute la hauteur de la fenêtre */
		    margin: 0; /* Enlève toute marge par défaut */
		    padding: 0; /* Enlève toute marge intérieure par défaut */
		    overflow: hidden; /* Empêche le défilement de la page */
		}

        h2 {
            margin: 0;
        }
        h1 {
            margin: 0;
            color : #800000;
        }

        main {
           
            background-color: rgba(255, 255, 255, 0.8); /* Fond blanc semi-transparent */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 500px; /* Largeur du formulaire */
            text-align: center;
        
        }

        h3 {
            color: #4CAF50;
            border-bottom: 2px solid #4CAF50;
            padding-bottom: 0.5rem;
        }

        ul {
            list-style-type: none;
            padding: 0;
        }

        ul li {
            margin: 0.5rem 0;
        }

        a {
            text-decoration: none;
            color: #4CAF50;
            font-weight: bold;
            transition: color 0.3s ease;
        }

        a:hover {
            color: #333;
        }

        footer {
            text-align: center;
            margin-top: 2rem;
            font-size: 0.9rem;
            color: #777;
        }
    </style>
</head>
<body>



<main>

	<h1>Page Administration</h1>
	<br>
	<br>
	
    <h2>Gérer les cafés</h2>
    <ul>
        <li>
            <a href="<%= request.getContextPath() %>/cafes">Liste des cafés</a>
        </li>
    </ul>

    <h2>Gérer les viennoiseries</h2>
    <ul>
        <li>
            <a href="<%= request.getContextPath() %>/viennoiseries">Liste des viennoiseries</a>
        </li>
    </ul>
    <footer>
         © 2024 - Page d'administration
    </footer>
    
</main>


</body>
</html>
