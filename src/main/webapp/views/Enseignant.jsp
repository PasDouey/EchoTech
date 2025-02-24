<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Enseignant</title>
    <link rel="stylesheet" href="Enseignant.css">
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
                <a href="#" onclick="showSection('emploi')">Emploi</a>
                <a href="#" onclick="showSection('notes')">Notes</a>
                <a href="#" onclick="showSection('absences')">Absences</a>
                <a href="#" class="logout2">Déconnexion</a>
            </nav>
        </aside>
    
        <!-- Content Area -->
        <main class="content" id="main-content">
            <header>
                <h1 id="section-title">Emploi du temps</h1>
                <hr>
            </header>
            <div id="section-content">
                <div style="text-align: center; margin-top: 20px;">
                    <img src="images/emploi.webp" alt="Emploi du temps" class = "emploi-image">
                </div>
                
                <div class="export-button-container">
                    <button class="export-button">
                        <img src="images/download-small (1).png" alt="Download" class="download-icon">
                        Exporter
                    </button>
                </div>
            </div>
        </main>
    </div>

    <script src="Enseignant.js"></script>
</body>
</html>
