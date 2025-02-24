<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription - Espace Numérique Scolaire</title>
    <link rel="stylesheet" href="sign-up.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="left-section">
            <h1>Espace Numérique <br> Scolaire</h1>
            <img src="images/signUp illust.svg" alt="Illustration éducative">
        </div>
        <div class="right-section">
            <h2>S'inscrire</h2>
            <form>
                <div class="name-fields">
                    <input type="text" placeholder="Nom" required>
                    <input type="text" placeholder="Prénom" required>
                </div>
                <input type="email" placeholder="Email" required>
                <input type="password" placeholder="Mot de passe" required>
                <select id="choix" name="choix" placeholder="Etudiant/Parent">
                    <option value="" disabled selected>Vous etes un Etudiant ou un Parent ?</option>
                    <option value="etudiant">Etudiant</option>
                    <option value="parent">Parent</option>
                </select>
                <button type="submit">Sign-up</button>
            </form>
            <p><a href="sign-in.jsp">Vous avez déjà un compte ?</a></p>
        </div>
    </div>
</body>
</html>
