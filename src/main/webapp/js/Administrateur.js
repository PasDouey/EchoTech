document.addEventListener("DOMContentLoaded", function () {
    function showSection(section) {
        let title = document.getElementById("section-title");
        let content = document.getElementById("section-content");

        if (section === "Eleves") {
            title.innerText = "Eleves";
            content.innerHTML = `
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
                                    <button class="edit"><img src="assets/edit (1).png" alt="Modifier"></button>
                                    <button class="delete"><img src="assets/x-button.png" alt="Supprimer"></button>
                                </td>
                            </tr>
                            <tr>
                                <td>Feddak</td>
                                <td>Mehdi</td>
                                <td>L81893</td>
                                <td>M0000000</td>
                                <td>College</td>
                                <td class="action-buttons">
                                    <button class="edit"><img src="assets/edit (1).png" alt="Modifier"></button>
                                    <button class="delete"><img src="assets/x-button.png" alt="Supprimer"></button>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            `;
        } 
        else if (section === "Enseignants") {
            title.innerText = "Enseignants";
            content.innerHTML = `
                
            <main class="content">
            <header>               
                <div class="search-container2">
                    <input type="text" placeholder="Chercher">
                    <button class="search-btn2">
                        <img src="assets/search (BLUE).svg" alt="Rechercher">
                    </button>
                    <button class="add-btn2">
                        <img src="assets/add-user.png" alt="Ajouter">
                    </button>
                </div>
            </header>

            <section class="teachers">
                <!-- 6 Cartes enseignants -->
                <div class="teacher-card">
                    <img src="assets/profile_male.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt="Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>

                <div class="teacher-card">
                    <img src="assets/profile-female.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt="Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>

                <div class="teacher-card">
                    <img src="assets/profile_male.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt="Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>

                <div class="teacher-card">
                    <img src="assets/profile-female.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt="Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>

                <div class="teacher-card">
                    <img src="assets/profile_male.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt= "Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>

                
                <div class="teacher-card">
                    <img src="assets/profile-female.svg" alt="Enseignant">
                    <h2>Youness Ouchen</h2>
                    <p>CIN :</p>
                    <p>TEL :</p>
                    <p>Spécialité :</p>
                    <p>Salaire :</p>
                    <div class="card-actions2">
                        <button class="edit2"><img src="assets/edit (1).png" alt = "Modifier"></button>
                        <button class="delete2"><img src="assets/x-button.png" alt="Supprimer"></button>
                    </div>
                </div>
            </section>
            </main>

            `;
        }
        else if (section === "Rapports") {
            title.innerText = "Rapports";
            content.innerHTML = `
            <div class="stats-container">
    
                <div class="stats-grid">
                        <div class="stat-card">
                            <div class="stat-icon">
                                <img src="assets/graduated.png" alt="Students Icon">
                            </div>
                            <div class="stat-content">
                                <div class="stat-label">Total Étudiants</div>
                                <div class="stat-value">1208</div>
                            </div>
                        </div>

                    <div class="stat-card">
                        <div class="stat-icon">
                            <img src="assets/teacher (1).png" alt="Teachers Icon">
                        </div>
                        <div class="stat-content">
                            <div class="stat-label">Total Enseignants</div>
                            <div class="stat-value">34</div>
                        </div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-icon">
                            <img src="assets/progressive.png" alt="Success Rate Icon">
                        </div>
                        <div class="stat-content">
                                <div class="stat-label">Teaux de Réussite</div>
                                <div class="stat-value">94%</div>
                        </div>
                    </div>

                    <div class="stat-card">
                        <div class="stat-icon">
                            <img src="assets/absentism.png" alt="Absence Rate Icon">
                         </div>
                        <div class="stat-content">
                            <div class="stat-label">Teaux d'Abscence</div>
                            <div class="stat-value">2%</div>
                        </div>
                    </div>
                </div>

                <div class="export-button-container">
                    <button class="export-button">
                        <img src="assets/download-small (1).png" alt="Download" class="download-icon">
                        Exporter
                    </button>
                </div>
            </div>
            `;
        }
    }

    // Make function global
    window.showSection = showSection;
});
