document.addEventListener("DOMContentLoaded", function () {
    function showSection(section) {
        let title = document.getElementById("section-title");
        let content = document.getElementById("section-content");

        if (section === "emploi") {
            title.innerText = "Emploi du temps";
            content.innerHTML = `
                <div style="text-align: center; margin-top: 20px;">
                    <img src="assets/emploi.webp" alt="Emploi du temps" class = "emploi-image"">
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
                            <img src="images/download-small (1).png" alt="Download" class="download-icon">
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
                            <img src="images/download-small (1).png" alt="Download" class="download-icon">
                            Exporter
                        </button>
                    </div>
                </div>
            `;
        }
    }

   
    window.showSection = showSection;
});
