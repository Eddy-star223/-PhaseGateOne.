const prompt = require("prompt-sync")();

function getCardType(cardNumber) {
  if (cardNumber.startsWith("4")) return "Visa";
  if (cardNumber.startsWith("5")) return "MasterCard";
  if (cardNumber.startsWith("37")) return "American Express";
  if (cardNumber.startsWith("6")) return "Discover";
  return null;
}

function isValidCard(cardNumber) {
  let total = 0;
  let doubleDigit = false;

  for (let counter = cardNumber.length - 1; counter >= 0; counter--) {
    let digit = parseInt(cardNumber[counter]);

    if (doubleDigit) {
      digit *= 2;
      if (digit > 9) digit -= 9;
    }

    total += digit;
    doubleDigit = !doubleDigit;
  }

  return total % 10 === 0;
}


let cardNumber = prompt("Hello, kindly enter card detail to verify:").replace(/[\s-]/g, "");

if (cardNumber.length < 13 || cardNumber.length > 16) {
  console.log("Invalid card length.");
} else {
  let type = getCardType(cardNumber);

  if (type) {
    console.log(`Credit card type: ${type}`);
    console.log(`Credit card number: ${cardNumber}`);
    console.log(`Credit card digit length: ${cardNumber.length}`);
    console.log(`Credit card validity status: ${isValidCard(cardNumber) ? "Valid" : "Invalid"}`);
  } else {
    console.log("Invalid card number.");
  }
}

