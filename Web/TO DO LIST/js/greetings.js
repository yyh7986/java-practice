const $loginForm = document.querySelector("#login-form");
const $loginInput = document.querySelector("#login-form input");
const $loginBtn = document.querySelector("#login-form button");
const $outputName = document.querySelector("#output-name");
const $greeting = document.querySelector("#greeting");

const HIDDEN_CLASSNAME = "hidden";
const USERNAME_KEY = "username";
const savedUsername = localStorage.getItem(USERNAME_KEY);

function submitLoginBtn(event) {
  event.preventDefault();
  const username = $loginInput.value;
  localStorage.setItem(USERNAME_KEY, username);
  showGreeting(username);
}

function showGreeting(username) {
  $greeting.innerText = `Hi! ${username}`;
  $loginForm.classList.add(HIDDEN_CLASSNAME);
  $greeting.classList.remove(HIDDEN_CLASSNAME);
}

if (savedUsername === null) {
  $loginForm.classList.remove(HIDDEN_CLASSNAME);
  $loginForm.addEventListener("submit", submitLoginBtn);
} else {
  showGreeting(savedUsername);
}
