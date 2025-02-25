document.addEventListener("DOMContentLoaded", function () {
    function showSection(section) {
        let title = document.getElementById("section-title");
        let content = document.getElementById("section-content");

        if (section === "emploi") {
            title.innerText = "Emploi du temps";
            content.innerHTML = `
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
            `;
        } 
        else if (section === "notes") {
            title.innerText = "Notes";
            content.innerHTML = `
                <div class="notes-container">
                    <table class="notes-table">
                        <thead>
                            <tr>
                                <th>Module</th>
                                <th>Note</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>JEE</td>
                                <td>16,02</td>
                            </tr>
                            <tr>
                                <td>Python</td>
                                <td>17,22</td>
                            </tr>
                        </tbody>
                    </table>
                    <div class="export-button-container">
                        <button class="export-button">
                            <img src="assets/download-small (1).png" alt="Download" class="download-icon">
                            Exporter
                        </button>
                    </div>
                </div>
            `;
        }
        else if (section === "absences") {
            title.innerText = "Absences";
            content.innerHTML = `
                <div class="notes-container">
                    <table class="notes-table">
                        <thead>
                            <tr>
                                <th>Date</th>
                                <th>Module</th>
                                <th>Nombre d'Heurs</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>21/07/2002</td>
                                <td>ORACLE</td>
                                <td>6</td>
                            </tr>
                            <tr>
                                <td>22/07/2002</td>
                                <td>ORACLE</td>
                                <td>8</td>
                            </tr>
                        </tbody>
                    </table>
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
   
    window.showSection = showSection;
});
