// Handle page navigation
document.getElementById("home-link").addEventListener("click", () => {
  scrollToSection("overview");
});

document.getElementById("messaging-link").addEventListener("click", () => {
  scrollToSection("features");
});

document
  .getElementById("driver-messages-link")
  .addEventListener("click", () => {
    alert("Driver messaging system will be available soon.");
  });

document.getElementById("owner-messages-link").addEventListener("click", () => {
  alert("Owner messaging system will be available soon.");
});

document.getElementById("tracking-link").addEventListener("click", () => {
  scrollToSection("statistics");
});

document.getElementById("gps-tracking-link").addEventListener("click", () => {
  alert("GPS tracking is coming soon.");
});

document
  .getElementById("route-optimization-link")
  .addEventListener("click", () => {
    alert("Route optimization is being updated.");
  });

document.getElementById("payments-link").addEventListener("click", () => {
  scrollToSection("recent-activity");
});

document.getElementById("invoices-link").addEventListener("click", () => {
  alert("Invoice history will be available shortly.");
});

document
  .getElementById("payment-history-link")
  .addEventListener("click", () => {
    alert("Payment history is coming soon.");
  });

document.getElementById("profile-link").addEventListener("click", () => {
  alert("User profile will be available soon.");
});

// Smooth scroll to sections
function scrollToSection(sectionId) {
  const section = document.getElementById(sectionId);
  window.scrollTo({
    top: section.offsetTop,
    behavior: "smooth",
  });
}

// Dynamic statistics updates
const stats = {
  deliveries: 145,
  activeTrucks: 23,
  pendingInvoices: 8,
  messagesReceived: 36,
};

function updateStats() {
  document.querySelectorAll(".stat-item").forEach((item, index) => {
    const statName = item
      .querySelector("h4")
      .textContent.toLowerCase()
      .replace(" ", "");
    item.querySelector("p").textContent = stats[statName];
  });
}

window.onload = updateStats;
