<!DOCTYPE html>
<html lang="fr">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Espace Etudiant</title>
    <link rel="stylesheet" href="Etudiant.css">
    <link href="https://fonts.googleapis.com/css2?family=Jura:wght@400;600&display=swap" rel="stylesheet">
</head>
<body> 
    <div class="container">
        <!-- Sidebar -->
        <aside class="sidebar">
            <div class="profile">
                <img src="assets/profile_male.svg" alt="Avatar">
                <p>Youness Ouchen</p>
            </div>
            <nav>
                <a href="">Accueil</a>
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
                <div class="custom-timetable-container">
                    <h2 class="custom-timetable-title">Emploi du temps première partie</h2>
                    <table class="custom-timetable">
                        <thead>
                            <tr>
                                <th>Horaires</th>
                                <th>Lundi</th>
                                <th>Mardi</th>
                                <th>Jeudi</th>
                                <th>Vendredi</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>08h30 - 10h15</td>
                                <td class="custom-cell-teal">-</td>
                                <td class="custom-cell-blue">Mathématiques</td>
                                <td class="custom-cell-lightgreen">Orale</td>
                                <td class="custom-cell-teal">Physique quantique</td>
                            </tr>
                            <tr>
                                <td>10h30 - 12h15</td>
                                <td class="custom-cell-blue">Physique quantique</td>
                                <td class="custom-cell-lightgreen">-</td>
                                <td class="custom-cell-teal">-</td>
                                <td class="custom-cell-blue">Java EE</td>
                            </tr>
                            <tr>
                                <td>14h30 - 16h15</td>
                                <td class="custom-cell-lightgreen">UML</td>
                                <td class="custom-cell-teal">JEE</td>
                                <td class="custom-cell-blue">Physique quantique</td>
                                <td class="custom-cell-lightgreen">-</td>
                            </tr>
                            <tr>
                                <td>16h30 - 18h15</td>
                                <td class="custom-cell-teal">Analyse SI</td>
                                <td class="custom-cell-blue">-</td>
                                <td class="custom-cell-lightgreen">Oracle</td>
                                <td class="custom-cell-teal">Java EE</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
                
                <div class="export-button-container">
                    <button class="export-button">
                        <img src="assets/download-small (1).png" alt="Download" class="download-icon">
                        Exporter
                    </button>
                </div>
            </div>
        </main>
    </div>

    <script src="Etudiant.js"></script>
</body>
</html>
