// Fonction pour exécuter du code (simulation)
function runCode(code) {
    try {
        // Pour sécurité, on évite eval() dans la démo
        if (code.includes('alert')) {
            alert("I'm JavaScript!");
        } else {
            console.log("Code exécuté:", code);
            alert("Le code a été exécuté (voir la console)");
        }
    } catch (error) {
        console.error("Erreur:", error);
        alert("Erreur d'exécution: " + error.message);
    }
}

// Fonction pour afficher du code
function showCode() {
    alert("Le code est déjà visible dans la page.");
}

// Démo de l'horloge
let demoClockInterval = null;

function showClockDemo() {
    const demo = document.getElementById('clock-demo');
    demo.style.display = 'block';
}

function startDemoClock() {
    if (demoClockInterval) return;
    
    function updateDemoClock() {
        const now = new Date();
        const hours = String(now.getHours()).padStart(2, '0');
        const minutes = String(now.getMinutes()).padStart(2, '0');
        const seconds = String(now.getSeconds()).padStart(2, '0');
        document.getElementById('demo-clock').textContent = 
            `${hours}:${minutes}:${seconds}`;
    }
    
    updateDemoClock();
    demoClockInterval = setInterval(updateDemoClock, 1000);
}

function stopDemoClock() {
    if (demoClockInterval) {
        clearInterval(demoClockInterval);
        demoClockInterval = null;
    }
}

// IMPORTANT: Le code de navigation des onglets est maintenant dans index.html
// dans un bloc <script> avec DOMContentLoaded