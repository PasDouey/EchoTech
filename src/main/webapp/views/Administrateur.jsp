<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Administrateur</title>
    <link rel="stylesheet" href="Administrateur.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body> 
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <div class="profile">
                <img src="images/profile_male.svg" alt="Avatar">
                <p>Youness Ouchen</p>
            </div>
            <nav>
                <a href="#" onclick="showSection('Eleves')">Eleves</a>
                <a href="#" onclick="showSection('Enseignants')">Enseignants</a>
                <a href="#" onclick="showSection('Rapports')">Rapports</a>
                <a href="#" class="logout2">Déconnexion</a>
            </nav>
        </aside>
    
        <!-- Content Area -->
        <main class="content" id="main-content">
            <header>
                <h1 id="section-title">Eleves</h1>
                <hr>
            </header>
            <div id="section-content">
                <div class="students-container">
                    
                    <div class="actions-bar">
                        <div class="search-container">
                            <input type="text" placeholder="CHERCHER..." class="search-input">
                        </div>
                        <button class="add-student-btn">
                            Ajouter un etudiant
                        </button>
                    </div>
                
                    <table class="students-table">
                        <thead>
                            <tr>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>CIN</th>
                                <th>CNE</th>
                                <th>Niveau</th>
                                <th>Action</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>AABABOU</td>
                                <td>A AMIN</td>
                                <td>VA1893</td>
                                <td>K0000000</td>
                                <td>College</td>
                                <td class="action-buttons">
                                    <button class="edit"><img src="images/edit (1).png" alt="Modifier"></button>
                                    <button class="delete"><img src="images/x-button.png" alt="Supprimer"></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Feddak</td>
                                <td>Mehdi</td>
                                <td>L81893</td>
                                <td>M0000000</td>
                                <td>College</td>
                                <td class="action-buttons">
                                    <button class="edit"><img src="images/edit (1).png" alt="Modifier"></button>
                                    <button class="delete"><img src="images/x-button.png" alt="Supprimer"></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </main>
    </div>

    <script src="Administrateur.js"></script>
</body>
</html>
