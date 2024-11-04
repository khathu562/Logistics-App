document
  .getElementById("registerPassword")
  .addEventListener("input", function () {
    const password = this.value;
    const meter = document.getElementById("passwordStrengthMeter");
    const text = document.getElementById("passwordStrengthText");

    let strength = 0;
    if (password.length >= 8) strength++;
    if (/[A-Z]/.test(password)) strength++;
    if (/[0-9]/.test(password)) strength++;
    if (/[\W]/.test(password)) strength++;

    meter.value = strength;

    switch (strength) {
      case 0:
      case 1:
        text.innerText = "Weak";
        text.style.color = "red";
        break;
      case 2:
        text.innerText = "Moderate";
        text.style.color = "orange";
        break;
      case 3:
      case 4:
        text.innerText = "Strong";
        text.style.color = "green";
        break;
    }
  });

function togglePasswordVisibility(passwordFieldId) {
  const passwordField = document.getElementById(passwordFieldId);
  passwordField.type = passwordField.type === "password" ? "text" : "password";
}

// Add more form validation logic as needed
