document.getElementById("rsvp-form").addEventListener("submit", function (e) {
  e.preventDefault(); // Prevent form submission

  // Get values from the form
  const name = document.getElementById("name").value;
  const email = document.getElementById("email").value;
  const guests = document.getElementById("guests").value;

  // Store RSVP information in local storage
  localStorage.setItem("rsvpName", name);
  localStorage.setItem("rsvpEmail", email);
  localStorage.setItem("rsvpGuests", guests);

  // Redirect to details page
  window.location.href = "details.html";
});

// On details.html page load
if (window.location.pathname.endsWith("details.html")) {
  const rsvpInfo = `
        <h2>Your RSVP Details:</h2>
        <p>Name: ${localStorage.getItem("rsvpName")}</p>
        <p>Email: ${localStorage.getItem("rsvpEmail")}</p>
        <p>Guests: ${localStorage.getItem("rsvpGuests")}</p>
    `;
  document.getElementById("rsvp-info").innerHTML = rsvpInfo;

  // Generate confetti effect
  setInterval(() => {
    createConfetti();
  }, 200);
}

function createConfetti() {
  const confetti = document.createElement("div");
  confetti.className = "confetti";
  confetti.style.left = Math.random() * 100 + "vw"; // Random horizontal position
  document.body.appendChild(confetti);

  // Remove the confetti after the animation
  setTimeout(() => {
    confetti.remove();
  }, 5000); // Remove after 5 seconds
}
