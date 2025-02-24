<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Connexion - Espace Numérique Scolaire</title>
<link rel="stylesheet" href="css/sign-in.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="left-section">
            <h1>Espace Numérique <br> Scolaire</h1>
            <a href="home"><img src="assets/Login-illus.svg" alt="Illustration éducative"></a>
        </div>
        <div class="right-section">
            <h2>Se Connecter</h2>
            <form action="login" method="post">
                <input type="email" name="email" placeholder="Email" required>
                <input type="password" name="password" placeholder="Mot de passe" required>
                <button type="submit">Se Connecter</button>
            </form>
            <p><a href="#" id="forgot-password-link">Mot de passe oublié ?</a></p>
            <p><a href="signup">Vous n'avez pas de compte ?</a></p>
        </div>
    </div>
</body>
<script>
    // Fonction pour afficher la pop-up
    function showForgotPasswordPopup() {
        alert("Veuillez contacter l'administration de l'école pour réinitialiser votre mot de passe.");
    }

    // Ajouter un écouteur d'événement au lien "Mot de passe oublié"
    document.getElementById("forgot-password-link").addEventListener("click", function(event) {
        event.preventDefault(); // Empêcher le comportement par défaut du lien
        showForgotPasswordPopup(); // Afficher la pop-up
    });
</script>
</html>