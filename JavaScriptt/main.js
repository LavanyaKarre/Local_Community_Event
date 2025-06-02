// Exercise 1
console.log("Welcome to the Community Portal");
window.onload = () => {
  alert("The page is fully loaded. Enjoy exploring community events!");
};

// Exercise 2
const eventList = [
  { name: "Community Music Night", date: "2025-06-15", seats: 30, category: "Music", location: "Park" },
  { name: "Workshop on Baking", date: "2025-05-25", seats: 0, category: "Workshop", location: "Community Hall" },
  { name: "Guitar Jam", date: "2025-07-01", seats: 20, category: "Music", location: "Library" },
];

// Exercise 3
function isValidEvent(event) {
  const today = new Date().toISOString().split("T")[0];
  return event.date >= today && event.seats > 0;
}

function displayEvents(events) {
  const container = document.getElementById("eventsContainer");
  container.innerHTML = '';
  events.forEach(event => {
    if (isValidEvent(event)) {
      const card = document.createElement("div");
      card.className = "event-card";
      card.innerHTML = `
        <h3>${event.name}</h3>
        <p>Date: ${event.date}</p>
        <p>Seats: ${event.seats}</p>
        <p>Category: ${event.category}</p>
        <button onclick="register('${event.name}')">Register</button>
      `;
      container.appendChild(card);
    }
  });
}

try {
  displayEvents(eventList);
} catch (error) {
  console.error("Error displaying events:", error);
}

// Exercise 4
function addEvent(event) {
  eventList.push(event);
}

function registerUser(eventName) {
  const event = eventList.find(e => e.name === eventName);
  if (event && event.seats > 0) {
    event.seats--;
    displayEvents(eventList);
  } else {
    alert("Event full or not found.");
  }
}

// Closure to track total registrations
function createCategoryTracker() {
  const count = {};
  return (category) => {
    count[category] = (count[category] || 0) + 1;
    return count[category];
  };
}
const trackRegistrations = createCategoryTracker();

// Higher-order function for filtering
function filterEvents(callback) {
  return eventList.filter(callback);
}

// Exercise 5
function Event(name, date, seats, category) {
  this.name = name;
  this.date = date;
  this.seats = seats;
  this.category = category;
}
Event.prototype.checkAvailability = function () {
  return this.seats > 0;
};
const bakingEvent = new Event("Cake Baking", "2025-06-20", 10, "Workshop");
console.log(Object.entries(bakingEvent));

// Exercise 6
eventList.push({ name: "Local Dance", date: "2025-07-10", seats: 15, category: "Music", location: "Gym" });

const musicEvents = eventList.filter(e => e.category === "Music");
const eventCards = musicEvents.map(e => `${e.category} Event: ${e.name}`);
console.log(eventCards);

// Exercise 7 - DOM already handled in displayEvents()

// Exercise 8
document.getElementById("categoryFilter").onchange = function (e) {
  const value = e.target.value;
  const filtered = value === "All" ? eventList : eventList.filter(ev => ev.category === value);
  displayEvents(filtered);
};

document.getElementById("searchInput").addEventListener("keydown", function (e) {
  const searchTerm = e.target.value.toLowerCase();
  const filtered = eventList.filter(ev => ev.name.toLowerCase().includes(searchTerm));
  displayEvents(filtered);
});

// Exercise 9
async function fetchEvents() {
  document.getElementById("eventsContainer").innerHTML = "Loading...";
  try {
    const res = await fetch("https://jsonplaceholder.typicode.com/posts");
    const data = await res.json();
    console.log("Fetched mock data:", data.slice(0, 3));
  } catch (err) {
    console.error("Fetch failed", err);
  }
}
fetchEvents();

// Exercise 10
const logEventDetails = ({ name, date, seats }) => {
  console.log(`Event: ${name}, Date: ${date}, Seats: ${seats}`);
};

const cloneList = [...eventList];
cloneList.forEach(logEventDetails);

// Exercise 11
document.getElementById("registrationForm").addEventListener("submit", function (e) {
  e.preventDefault();
  const { name, email, selectedEvent } = e.target.elements;
  if (!name.value || !email.value) {
    alert("All fields required.");
    return;
  }
  console.log("Form Submitted:", name.value, email.value, selectedEvent.value);
});

// Populate event dropdown
const dropdown = document.querySelector("select[name='selectedEvent']");
eventList.forEach(ev => {
  const opt = document.createElement("option");
  opt.value = ev.name;
  opt.innerText = ev.name;
  dropdown.appendChild(opt);
});

// Exercise 12
function postRegistration(data) {
  fetch("https://jsonplaceholder.typicode.com/posts", {
    method: "POST",
    body: JSON.stringify(data),
    headers: { "Content-Type": "application/json" }
  })
    .then(response => response.json())
    .then(json => {
      console.log("Registration successful:", json);
      alert("Registered successfully!");
    })
    .catch(err => alert("Failed to register"));

  setTimeout(() => console.log("Simulating server delay..."), 1000);
}

// Exercise 13
// Debugging Steps
// 1. Inspect form submit event
// 2. Check fetch payload
// 3. Use breakpoints and console.log() added

// Exercise 14 - jQuery
$('#categoryFilter').change(function () {
  $('#eventsContainer .event-card').fadeOut(200, () => {
    displayEvents(eventList);
    $('.event-card').fadeIn(500);
  });
});

// React/Vue Benefit
console.log("Benefit of frameworks: React/Vue make UI state management easier and scalable.");
