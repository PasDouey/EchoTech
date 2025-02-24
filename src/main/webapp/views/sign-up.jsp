<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Inscription - Espace Numérique Scolaire</title>
    <link rel="stylesheet" href="css/sign-up.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body>
    <div class="container">
        <div class="left-section">
            <h1>Espace Numérique <br> Scolaire</h1>
            <a href="home"><img src="assets/signUp illust.svg" alt="Illustration éducative"></a>
        </div>
        <div class="right-section">
            <h2>S'inscrire</h2>
            <form action="signup" method="post">
			    <div class="name-fields">
			        <input type="text" name="firstName" placeholder="Prénom" required>
			        <input type="text" name="lastName" placeholder="Nom" required>
			    </div>
			    <input type="email" name="email" placeholder="Email" required>
			    <input type="password" name="password" placeholder="Mot de passe" required>
			    <input type="text" name="cne" placeholder="CNE (Code National d'Étudiant)" required>
			    <select name="studyLevel" required>
			        <option value="" disabled selected>Sélectionnez votre année scolaire</option>
			        <!-- Primaire -->
			        <optgroup label="Primaire">
			            <option value="cp">CP (Cours Préparatoire)</option>
			            <option value="ce1">CE1 (Cours Élémentaire 1)</option>
			            <option value="ce2">CE2 (Cours Élémentaire 2)</option>
			            <option value="cm1">CM1 (Cours Moyen 1)</option>
			            <option value="cm2">CM2 (Cours Moyen 2)</option>
			        </optgroup>
			        <!-- Collège -->
			        <optgroup label="Collège">
			            <option value="6eme">6ème</option>
			            <option value="5eme">5ème</option>
			            <option value="4eme">4ème</option>
			            <option value="3eme">3ème</option>
			        </optgroup>
			        <!-- Lycée -->
			        <optgroup label="Lycée">
			            <option value="2nde">Seconde</option>
			            <option value="1ere">Première</option>
			            <option value="terminale">Terminale</option>
			        </optgroup>
			    </select>
			    <!-- Birthday Field -->
			    <input type="date" name="birthday" required>
			    <button type="submit">S'inscrire</button>
			</form>
            <p><a href="login">Vous avez déjà un compte ?</a></p>
        </div>
    </div>
</body>
</html>