<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion</title>
    <!-- Ajouter Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        /* Image de fond */
        body {
            background-image: url('images/1caffer.jpg'); /* Remplacez par l'URL de votre image */
            background-size: cover;
            background-position: center;
            background-attachment: fixed;
            font-family: Arial, sans-serif;
            height: 100vh;
            margin: 0;
            display: flex;
            justify-content: center; /* Centrer horizontalement */
            align-items: center; /* Centrer verticalement */
        }

	    .form-label {
	        text-align: left;
	        display: block; 
	    }


        /* Conteneur de connexion */
        .login-container {
            background-color: rgba(255, 255, 255, 0.8); /* Fond blanc semi-transparent */
            padding: 30px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
            width: 100%;
            max-width: 400px; /* Largeur du formulaire */
            text-align: center;
        }

        .login-container h2 {
            text-align: center;
            margin-bottom: 30px;
        }

        .form-control {
            border-radius: 20px;
        }

        .btn-custom {
            border-radius: 20px;
        }

        .error-message {
            color: red;
            text-align: center;
            font-weight: bold;
        }
    </style>
</head>
<body>

    <!-- Conteneur de connexion -->
    <div class="login-container">
        <h2>Connexion</h2>
        <form action="login" method="post">
            <div class="mb-3">
                <label for="username" class="form-label">Utilisateur :</label>
                <input type="text" name="username" id="username" class="form-control" required>
            </div>
            <div class="mb-3">
                <label for="password" class="form-label">Mot de passe :</label>
                <input type="password" name="password" id="password" class="form-control" required>
            </div>
            <div class="text-center mb-3">
                <button type="submit" class="btn btn-primary btn-custom w-100">Connecter</button>
            </div>
            <p class="error-message">${error}</p>
        </form>
    </div>

    <!-- Ajouter Bootstrap JS (pour les composants interactifs comme les alertes ou modal) -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
