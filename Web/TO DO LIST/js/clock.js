const $clock = document.querySelector("#clock");

function showCurrentTime() {
  const date = new Date();
  const hour =
    date.getHours() > 12
      ? `PM ${date.getHours() - 12}`
      : `AM ${date.getHours()}`;
  const min = date.getMinutes();
  const sec = date.getSeconds();

  $clock.innerText = `${hour}시 ${min}분 ${String(sec).padStart(2, "0")}초`;
}
showCurrentTime();
setInterval(showCurrentTime, 1000);
