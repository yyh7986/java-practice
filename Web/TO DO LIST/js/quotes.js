const quotes = [
  {
    quote:
      "I believe every human has a finite number of heartbeats. I don't intend to waste any of mine.",
    author: "Neil Armstrong",
  },
  {
    quote:
      "Live as if you were to die tomorrow. Learn as if you were to live forever.",
    author: "Mahatma Gandhi",
  },
  {
    quote:
      "If you live long enough, you'll make mistakes. But if you learn from them, you'll be a better person.",
    author: "Bill Clinton",
  },
  {
    quote: "Life is short, and it is here to be lived.",
    author: "Kate Winslet ",
  },
  {
    quote: "The longer I live, the more beautiful life becomes.",
    author: "Frank Lloyd Wright",
  },
  {
    quote: "Every moment is a fresh beginning.",
    author: "T.S. Eliot",
  },
  {
    quote: "When you cease to dream you cease to live.",
    author: "Malcolm Forbes",
  },
  {
    quote:
      "If you spend your whole life waiting for the storm, you'll never enjoy the sunshine.",
    author: "Morris West",
  },
  {
    quote: "Don't cry because it's over, smile because it happened.",
    author: "Dr. Seuss ",
  },
  {
    quote:
      "If you can do what you do best and be happy, you're further along in life than most people.",
    author: "Leonardo DiCaprio",
  },
];

const $quote = document.querySelector("#quote span:first-child");
const $author = document.querySelector("#quote span:last-child");

let randomIndex = Math.floor(Math.random() * quotes.length);

$quote.innerText = quotes[randomIndex].quote;
$author.innerText = `\n${quotes[randomIndex].author}`;
