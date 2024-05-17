<span style="font-family: verdana, geneva, sans-serif;"><!DOCTYPE html>
<html lang="en">
<head>
  <title>Job Dashboard | By Code Info</title>
  <link rel="stylesheet" href="css/home-style.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
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
        
        <h1>Expences:</h1>

      <div class="search_bar">
        <input type="search" placeholder="expences">
        <input type="search" placeholder="description">
        <select name="" id="">
          <option>Type</option>
          <option>Rent</option>
          <option>Insurance</option>
          <option>Taxes</option>
          <option>Subscription Services</option>
          <option>Childcare</option>
          <option>Utilities</option>
        </select>
       
          <input type="date" id="start" name="trip-start"
           value="2024-05-01"
           min="2022-01-01" max="2029-12-31">
           <button type="button" onclick="customFunction()">
            <i class="fas fa-plus"></i> 
        </button>
        <button type="button" onclick="customFunction()">
          <i class="fas fa-pen"></i>
      </button>
      <button type="button" onclick="customFunction()">
        <i class="fas fa-trash"></i> 
    </button>

           <script>
           function customFunction() {
               alert('Button clicked!');
           }
           </script>
           
      </div>

      

      <table>
        <thead>
          <tr>
            <th>Expense</th>
            <th>Description</th>
            <th>Type</th>
            <th>Date</th>
          </tr>
        </thead>
       
      </table>

</body>
</html></span>
