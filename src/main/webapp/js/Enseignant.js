document.addEventListener("DOMContentLoaded", function () {
    function showSection(section) {
        let title = document.getElementById("section-title");
        let content = document.getElementById("section-content");

        if (section === "emploi") {
            title.innerText = "Emploi du temps";
            content.innerHTML = `
                <div style="text-align: center; margin-top: 20px;">
                    <img src="images/emploi.webp" alt="Emploi du temps" class = "emploi-image"">
                </div>
                <div class="export-button-container">
                    <button class="export-button">
                        <img src="images/download-small (1).png" alt="Download" class="download-icon">
                        Exporter
                    </button>
                </div>
            `;
        } 
        else if (section === "notes") {
            title.innerText = "Notes";
            content.innerHTML = `
                <div class="notes-container">
                    <table class="notes-table">
                        <thead>
                            <tr>
                                <th>CIN</th>
                                <th>Nom</th>
                                <th>Preom</th>
                                <th>Note</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>M130474152</td>
                                <td>AABABOU</td>
                                <td>A AMIN</td>
                                <td>14,02</td>
                            </tr>
                            <tr>
                                <td>M130474152</td>
                                <td>AABABOU</td>
                                <td>A AMIN</td>
                                <td>15,62</td>
                            </tr>
                        </tbody>
                    </table>

                    <form class="notes-form">
                        <div class="form-group">
                            <label for="cne">CNE :</label>
                            <input type="text" id="cne" class="form-input" placeholder="M00000000" name="cne">
                        </div>
                        <div class="form-group">
                            <label for="note">Note :</label>
                            <input type="text" id="note" class="form-input" placeholder="0" name="note">
                        </div>
                        <div class="form-buttons">
                            <button type="submit" class="btn btn-add">Ajouter</button>
                            <button type="button" class="btn btn-modify">Modifier</button>
                        </div>
                    </form>

                </div>
            `;
        }
        else if (section === "absences") {
            title.innerText = "Absences";
            content.innerHTML = `
                <div class="abscence-container">
                    <table class="abscence-table">
                        <thead>
                            <tr>
                                <th>CIN</th>
                                <th>Nom</th>
                                <th>Preom</th>
                                <th>Date</th>
                                <th>Nb Heurs</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>M130474152</td>
                                <td>AABABOU</td>
                                <td>A AMIN</td>
                                <td>21/07/2002</td>
                                <td>0</td>
                            </tr>
                            <tr>
                                <td>M130474152</td>
                                <td>AABABOU</td>
                                <td>A AMIN</td>
                                <td>22/07/2002</td>
                                <td>8</td>
                            </tr>
                        </tbody>
                    </table>
                    <form class="notes-form">
                        <div class="form-group">
                            <label for="cne">CNE :</label>
                            <input type="text" id="cne" class="form-input" placeholder="M00000000" name="cne">
                        </div>
                        <div class="form-group">
                            <label for="date">Date :</label>
                            <input type="date" id="date" class="form-input" name="date">
                        </div>
                        <div class="form-group">
                            <label for="hours">Nb Heurs :</label>
                            <input type="text" id="hours" class="form-input" placeholder="2" name="hours">
                        </div>
                        <div class="form-buttons">
                            <button type="submit" class="btn btn-add">Ajouter</button>
                            <button type="button" class="btn btn-modify">Modifier</button>
                        </div>
                    </form>

                </div>
            `;
        }
    }


    window.showSection = showSection;
});
