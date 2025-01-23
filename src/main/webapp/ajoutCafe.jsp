<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Ajouter un café</title>
    <style>
        body {
            font-family: Arial, sans-serif;       
            background-image: url('images/2caffer.jpg'); /* Image de fond pour le body */
            margin: 0;
            padding: 0;
            background-image: url('images/2caffer.jpg'); /* Image de fond pour le body */
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
        .form-container {
            background-color: rgba(255, 255, 255, 0.8);
            padding: 2rem;
            border-radius: 8px;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px;
        }

        h2 {
            text-align: center;
            color: #800000;
            margin-bottom: 1rem;
        }

        form {
            display: flex;
            flex-direction: column;
        }

        label {
            margin-bottom: 0.5rem;
            font-weight: bold;
        }

        input[type="text"] {
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 1rem;
            font-size: 1rem;
        }
        input[type="number"] {
            padding: 0.5rem;
            border: 1px solid #ccc;
            border-radius: 4px;
            margin-bottom: 1rem;
            font-size: 1rem;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: white;
            border: none;
            padding: 0.7rem;
            font-size: 1rem;
            border-radius: 4px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }

        .return-btn {
            background-color: #f44336;
            margin-top: 1rem;
        }

        .return-btn:hover {
            background-color: #d32f2f;
        }
    </style>
</head>
<body>

<div class="form-container">
    <h2>Ajouter un nouveau Café</h2>
    <form action="AjouterCafe" method="POST">
        <label for="cafeName">Nom du café :</label>
        <input type="text" id="cafeName" name="cafeName" placeholder="Entrez le nom du café" required>

        <label for="FoID">Fournisseur ID :</label>
        <input type="number" id="FoID" name="FoID" placeholder="Entrez l'ID du fournisseur" required>

        <label for="prix">Prix :</label>
        <input type="number" id="prix" name="prix" step="0.01" placeholder="Entrez le prix" required>

        <label for="ventes">Ventes :</label>
        <input type="number" id="ventes" name="ventes" placeholder="Entrez les ventes" required>

        <input type="submit" value="Ajouter">
    </form>

    <form action="cafes" method="GET">
        <input type="submit" value="Retour" class="return-btn">
    </form>
</div>

</body>
</html>
