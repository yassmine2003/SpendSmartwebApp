<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Spend Smart Dashboard</title>
  <link rel="stylesheet" href="css/home-style.css" />
  <!-- Font Awesome Cdn Link -->
  <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" />
</head>
<body>
<div class="container">
  <nav>
    <div class="navbar">
      <div class="logo">
        <img src="images/WhatsApp Image 2024-05-17 at 4.12.40 AM.jpeg" alt="">
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


  <form method="post" id="expenseForm">
      <TABLE BORDER="1" id="orderTable">
        <tr>
          <td>Expense</td>
          <td>Description</td>
          <td>Type</td>
          <td>Date</td>
        </tr>
      </TABLE>

      <button type="button" class="push_button blue" onclick="addRow()" formaction="AddS">Add</button>
      <button id="editButton" class="push_button blue" type="button" onclick="editRow()" formaction="ModifyS">Edit</button>
    </form>

      <script type="text/javascript" src="js/jquery-1.11.3.js"></script>
      <script type="text/javascript" src="js/table.js"></script>
    </div>
  </section>
</div>

</body>
</html>
