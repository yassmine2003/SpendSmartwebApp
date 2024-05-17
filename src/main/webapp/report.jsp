<!DOCTYPE html>
  <html lang="en">
  <head>
    <title>SpendSmart</title>
    <link rel="stylesheet" href="report-style.css" />
    
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
    <link href="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.css" rel="stylesheet" />
    
    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    
    <script src="https://cdn.jsdelivr.net/npm/fullcalendar@5.11.3/main.min.js"></script>
  </head>
  <body>
    <div class="container">
      <nav>
        <div class="navbar">
          <div class="logo">
            <img src="WhatsApp Image 2024-05-17 at 4.12.40 AM.jpeg" alt="">
            <h1>SpendSmart</h1>
          </div>
          <ul>
            <li><a href="#">
              <i class="fas fa-home"></i>
              <span class="nav-item">Home</span>
            </a>
            </li>
            <li><a href="#">
              <i class="fas fa-user"></i>
              <span class="nav-item">Profile</span>
            </a>
            </li>
            <li><a href="#">
              <i class="fas fa-tasks"></i>
              <span class="nav-item">Report</span>
            </a>
            </li>
            <li><a href="#">
              <i class="fas fa-sign-out-alt"></i>
              <span class="nav-item">LogOut</span>
            </a>
            </li>
          </ul>
        </div>
      </nav>
  
      <section class="main">
        
        <div class="main-body">
          
          <h1>Modify Your Profile Here:</h1>
          <div class="search_bar">
            <label>Month:</label>
            <input type="month" id="start" name="trip-start">
            <label>Balance:</label>
            <input type="search" placeholder="balance">
            <label>Monthly Budget:</label>
            <input type="search" placeholder="monthly budget">
            <label>Savings:</label>
            <input type="search" placeholder="savings">
            <button type="submit">Enter</button>
          </div>
          
             
        </div>
        <div class="calendar-container" id="calendar"></div>

  <script>
    document.addEventListener('DOMContentLoaded', function() {
      var calendarEl = document.getElementById('calendar');
      var calendar = new FullCalendar.Calendar(calendarEl, {
        initialView: 'dayGridMonth'
      });
      calendar.render();
    });
  </script>

  
  </body>
  </html>