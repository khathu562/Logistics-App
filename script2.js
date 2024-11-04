document.getElementById("rock").addEventListener("click", function () {
  playGame("rock");
});
document.getElementById("paper").addEventListener("click", function () {
  playGame("paper");
});
document.getElementById("scissors").addEventListener("click", function () {
  playGame("scissors");
});

function playGame(playerChoice) {
  const computerChoice = getComputerChoice();
  const resultMessage = determineWinner(playerChoice, computerChoice);
  document.getElementById("result-message").textContent = resultMessage;
}

function getComputerChoice() {
  const choices = ["rock", "paper", "scissors"];
  const randomIndex = Math.floor(Math.random() * choices.length);
  return choices[randomIndex];
}

function determineWinner(playerChoice, computerChoice) {
  if (playerChoice === computerChoice) {
    return "It's a tie!";
  } else if (playerChoice === "rock" && computerChoice === "scissors") {
    return "You win! Rock beats scissors.";
  } else if (playerChoice === "rock" && computerChoice === "paper") {
    return "You lose! Paper beats rock.";
  } else if (playerChoice === "paper" && computerChoice === "rock") {
    return "You win! Paper beats rock.";
  } else if (playerChoice === "paper" && computerChoice === "scissors") {
    return "You lose! Scissors beats paper.";
  } else if (playerChoice === "scissors" && computerChoice === "paper") {
    return "You win! Scissors beats paper.";
  } else if (playerChoice === "scissors" && computerChoice === "rock") {
    return "You lose! Rock beats scissors.";
  }
}
